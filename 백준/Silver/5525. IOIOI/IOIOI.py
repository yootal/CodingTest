import sys
input = sys.stdin.readline

def failure(s):
    f = [0] * add_v
    j = 0
    for i in range(1,add_v):
        while j > 0 and s[i] != s[j]:
            j = f[j-1]
        if s[i] == s[j]:
            j += 1 
            f[i] = j
    return f

n = int(input())
m = int(input())
s = input().rstrip()
add_v = 2*n+1

p = ""
for i in range(add_v):
    if i % 2 == 1:
        p += "O"
    else:
        p += "I"

f = failure(p)
ans = 0
j = 0
for i in range(m):
    while j > 0 and s[i] != p[j]:
        j = f[j-1]
    if s[i] == p[j]:
        j += 1
    if j == add_v:
        ans += 1
        j = f[j-1]
        
print(ans)