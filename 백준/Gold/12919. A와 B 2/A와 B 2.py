from sys import stdin
input = stdin.readline

def solve(s):
    global ans
    if len(s) < len(s1):
        return
    if s == s1:
        ans = 1
        return
    if s[-1] == 'A':
        solve(s[:-1])
    if s[0] == 'B':
        s = s[::-1]
        solve(s[:-1])

s1 = input().rstrip()
s2 = input().rstrip()
ans = 0
solve(s2)
print(ans)
