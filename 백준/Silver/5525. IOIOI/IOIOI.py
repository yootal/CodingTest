import sys
input = sys.stdin.readline

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

ans = 0
for i in range(m-add_v+1):
    if s[i] == 'I':
        if s[i:i+(add_v)] == p:
            ans += 1
print(ans)