import sys 
input = sys.stdin.readline

inp = int(input())

dp = [0 for _ in range(inp+1)]

dp[inp] = 0

for i in range(inp-1,0,-1):
    if i*3 <= inp:
        dp[i] = min(dp[i*2], dp[i*3], dp[i+1]) + 1
    elif i*2 <= inp:
        dp[i] = min(dp[i*2],dp[i+1]) + 1
    else:
        dp[i] = dp[i+1] + 1

print(dp[1])