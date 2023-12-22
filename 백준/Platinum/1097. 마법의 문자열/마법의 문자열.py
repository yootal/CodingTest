from sys import stdin
from itertools import permutations
input = stdin.readline

def failure(s):
    f = [0] * len(s)
    j = 0
    for i in range(1,len(s)):
        while j > 0 and s[i] != s[j]:
            j = f[j-1]
        if s[i] == s[j]:
            j += 1
            f[i] = j
    return f

n = int(input())
word = [input().rstrip() for _ in range(n)]
k = int(input())
ans = 0
for per in permutations(word,n):
    w = ''.join(per)
    w2 = w*2
    f = failure(w)
    j = 0
    cnt = 0
    for i in range(len(w2)):
        while j > 0 and w2[i] != w[j]:
            j = f[j-1]
        if w2[i] == w[j]:
            j += 1
        if j == len(w):
            cnt += 1
            j = f[j-1]
    if cnt - 1 == k:
        ans += 1
print(ans)