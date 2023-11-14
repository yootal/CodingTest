from sys import stdin
input = stdin.readline

n,m = map(int,input().split())
acitve = [0] + list(map(int,input().split()))
inactive = [0] + list(map(int,input().split()))
dp = [[0 for _ in range(sum(inactive)+1)] for _ in range(n+1)]
ans = 10001

for i in range(1,n+1):
    memory = acitve[i]
    cost = inactive[i]
    for j in range(sum(inactive)+1):
        dp[i][j] = dp[i-1][j]
    for j in range(cost,sum(inactive)+1):
        dp[i][j] = max(dp[i][j], memory + dp[i-1][j-cost])
        if dp[i][j] >= m:
            ans = min(ans,j)
            
print(ans)