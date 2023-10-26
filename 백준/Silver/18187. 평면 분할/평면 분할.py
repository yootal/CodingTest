from sys import stdin
input = stdin.readline

n = int(input())

dp = [0] * 101
dp[1] = 2
dp[2] = 4

w = 3
for i in range(3,n+1):
    dp[i] = dp[i-1] + w
    if i % 3 != 0:
        w += 1

print(dp[n])