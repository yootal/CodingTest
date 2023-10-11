from sys import stdin
input = stdin.readline

n = int(input())
board = [list(map(int,input().split())) for _ in range(n)]

dp = [[0] * (n) for _ in range(n)]
dp[0][0] = 1

for i in range(n):
    for j in range(n): 
        if i == n-1 and j == n-1:
            break
        if 0 <= i + board[i][j] < n:
            dp[i+board[i][j]][j] += dp[i][j]
        if 0 <= j + board[i][j] < n:
            dp[i][j+board[i][j]] += dp[i][j]

print(dp[n-1][n-1])