dp = [0] * 101
dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2

for _ in range(int(input())):
    n = int(input())
    for k in range(6,n+1):
        dp[k] = (dp[k-1] + dp[k-5])
    print(dp[n])