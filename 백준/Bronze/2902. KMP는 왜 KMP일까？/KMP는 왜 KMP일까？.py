import sys
input = sys.stdin.readline

inp = list(input().rstrip().split("-"))
ans = ""
for s in inp:
    ans += s[0]

print(ans)