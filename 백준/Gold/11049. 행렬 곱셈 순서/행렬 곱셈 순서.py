from sys import stdin, maxsize
input = stdin.readline

n = int(input())
matrix = [tuple(map(int,input().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]

for i in range(1,n): # 몇 번째 대각선
    for st in range(n-i): # 대각선에서 몇 번째 열
        if i == 1:
            dp[st][st+i] = matrix[st][0] * matrix[st][1] * matrix[st+i][1]
            continue
        dp[st][st+i] = maxsize
        for k in range(st,st+i):
            dp[st][st+i] = min(dp[st][st+i],dp[st][k] + dp[k+1][st+i] + matrix[st][0] * matrix[k][1] * matrix[st+i][1])
            
print(dp[0][n-1])