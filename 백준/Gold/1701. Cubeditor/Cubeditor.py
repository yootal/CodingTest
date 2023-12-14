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
    return max(f)

s = input().rstrip()
ans = 0
for i in range(len(s)):
    temp = s[i:len(s)]
    ans = max(ans,failure(temp))
print(ans)
