from sys import stdin
input = stdin.readline

n,m,k = map(int,input().split())
dp = [[0] * (m+1) for _ in range(n+1)]
dp[1][1] = 1

if k == 0:
    for i in range(1,n+1):
        for j in range(1,m+1):
            if i == 1 and j == 1:
                continue
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
    print(dp[n][m])
    
else:
    row = k // m + 1
    col = k % m

    for i in range(1,row+1):
        for j in range(1,col+1):
            if i == 1 and j == 1:
                continue
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
    cnt = dp[row][col]    
    
    dp[row][col] = 1
    for i in range(row,n+1):
        for j in range(col,m+1):
            if i == row and j == col:
                continue
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
    cnt2 = dp[n][m]
    
    print(cnt * cnt2)