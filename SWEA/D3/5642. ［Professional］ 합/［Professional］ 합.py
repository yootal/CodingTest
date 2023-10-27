t = int(input())
for case in range(1, t + 1):
    n = int(input())
    dp = list(map(int, input().split()))
    for i in range(1, n):
        if dp[i] < dp[i - 1] + dp[i]:
            dp[i] = dp[i - 1] + dp[i]
    print(f'#{case} {max(dp)}')