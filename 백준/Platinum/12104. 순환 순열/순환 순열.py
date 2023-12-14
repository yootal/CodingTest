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

s1 = input().rstrip()
s2 = input().rstrip()
s = s2 + s2[:-1]
f = failure(s1)
ans = 0
j = 0
for i in range(len(s)):
    while j > 0 and s[i] != s1[j]:
        j = f[j-1]
    if s[i] == s1[j]:
        j += 1
    if j == len(s1):
        ans += 1
        j = f[j-1]
print(ans)