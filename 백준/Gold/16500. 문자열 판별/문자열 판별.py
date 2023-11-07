from sys import stdin
input = stdin.readline
    
s = input().rstrip()
n = int(input())
a = []
dp = [False] * 101
for _ in range(n):
    a.append(input().rstrip())

def solve(idx):
    global ans
    if idx == len(s):
        ans = 1
        return
    if dp[idx]:
        return
    dp[idx] = True
    for i in range(len(a)):
        if len(s[idx:]) >= len(a[i]):
            for j in range(len(a[i])):
                if a[i][j] != s[idx+j]:
                    break
            else:
                solve(idx+len(a[i]))

ans = 0
solve(0)
print(ans)