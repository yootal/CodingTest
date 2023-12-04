from sys import stdin, maxsize
input = stdin.readline

n = int(input())
cost = [tuple(map(int,input().split())) for _ in range(n)]
dp = [maxsize] * (1 << n)

def solve(user,work_bitmask):
    if user == n:
        return 0
    if dp[work_bitmask] != maxsize:
        return dp[work_bitmask]
    c = maxsize
    for i in range(n):
        if work_bitmask & (1 << i):
            continue
        c = min(c,solve(user + 1, work_bitmask | (1 << i)) + cost[user][i])
    dp[work_bitmask] = c
    return dp[work_bitmask]

print(solve(0,0))