for t in range(int(input())):
    n, k = map(int, input().split())
    dp = [[0] * (k + 1) for _ in range(n + 1)]
    info = [tuple(map(int, input().split())) for _ in range(n)]
    for i in range(1, n + 1):
        size = info[i - 1][0]
        value = info[i - 1][1]
        for j in range(1, k + 1):
            if j < size:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - size] + value)
    print(f"#{t + 1} {dp[n][k]}")