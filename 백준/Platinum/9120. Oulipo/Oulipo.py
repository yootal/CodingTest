from sys import stdin
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
for _ in range(n):
    a = input().rstrip()
    b = input().rstrip()
    f = failure(a)
    ans = 0
    j = 0
    for i in range(len(b)):
        while j > 0 and b[i] != a[j]:
            j = f[j-1]
        if b[i] == a[j]:
            j += 1
        if j == len(a):
            ans += 1
            j = f[j-1]
    print(ans)