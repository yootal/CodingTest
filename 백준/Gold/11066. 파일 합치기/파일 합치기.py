from sys import stdin
input = stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    cost = [0] + list(map(int,input().split()))
    dp = [[0] * (n+1) for _ in range(n+1)] # dp[x][y] = x부터 y까지 최소비용
    
    for i in range(1,n):
        dp[i][i+1] = cost[i] + cost[i+1]
        for j in range(i+2,n+1):
            dp[i][j] = dp[i][j-1] + cost[j]
    
    for gap in range(2,n):
        for i in range(1,n-gap+1):
            j = i + gap
            dp[i][j] += min(dp[i][k] + dp[k+1][j] for k in range(i,j))
    
    print(dp[1][n])