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
num = list(map(int,input().split()))[::-1]
f = failure(num)

max_len = 0
ans = 0
for i in range(n):
    if f[i] > max_len:
        max_len = f[i]
        ans = 1
    elif f[i] == max_len:
        ans += 1
        
if max_len == 0:
    print(-1)
else:
    print(max_len,ans)
