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

s,k = input().rstrip().split()
k = int(k)
f = failure(s)
length = f[len(s)-1]
ans = len(s) + (len(s) - length) * (k-1)
print(ans)