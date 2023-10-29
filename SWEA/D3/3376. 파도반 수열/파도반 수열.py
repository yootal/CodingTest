dp = [0] * 101
dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2
for i in range(6, 101):
    dp[i] = dp[i - 1] + dp[i - 5]

t = int(input())
for case in range(1, t + 1):
    n = int(input())
    print(f'#{case} {dp[n]}')