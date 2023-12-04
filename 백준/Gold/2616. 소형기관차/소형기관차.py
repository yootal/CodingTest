from sys import stdin
input = stdin.readline

n = int(input())
num = list(map(int,input().split()))
m = int(input())

prefix = [0] + num[:]
for i in range(2,n+1):
    prefix[i] += prefix[i-1]

dp = [[0] * (n+1) for _ in range(4)]
for i in range(1,4):
    for j in range(m*i,n+1):
        if i == 1:
            dp[i][j] = max(dp[i][j-1],prefix[j]-prefix[j-m])
        else:
            dp[i][j] = max(dp[i][j-1],dp[i-1][j-m]+prefix[j]-prefix[j-m])

print(dp[3][n])
