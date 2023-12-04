from sys import stdin
input = stdin.readline

n = int(input())
num = list(map(int,input().split()))
m = int(input())

dp = [[0] * (n+1) for _ in range(4)]
for i in range(1,4):
    for j in range(m*i,n+1):
        dp[i][j] = max(dp[i][j-1],dp[i-1][j-m] + sum(num[j-m:j]))

print(dp[3][n])
