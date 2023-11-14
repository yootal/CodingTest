t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    dp = [[0] * (n + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1]
    ans = 0
    for i in range(m, n + 1):
        for j in range(m, n + 1):
            ans = max(ans, dp[i][j] - dp[i][j - m] - dp[i - m][j] + dp[i - m][j - m])
    print(f'#{case} {ans}')