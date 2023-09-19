import sys
input = sys.stdin.readline

t,w = map(int,input().split())

dp = [[0] * (w+1) for _ in range(t+1)]

for i in range(1,t+1):
    jadu = int(input())
    
    if jadu == 1:
        for j in range(w+1):
            if j % 2 == 0:
                if j == 0:
                    dp[i][j] = dp[i-1][j] + 1
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i-1][j-1]) + 1
            else:
                dp[i][j] = dp[i-1][j]
    
    elif jadu == 2:
        for j in range(w+1):
            if j % 2 == 1:
                dp[i][j] = max(dp[i-1][j],dp[i-1][j-1]) + 1
            else:
                dp[i][j] = dp[i-1][j]

print(max(dp[t]))