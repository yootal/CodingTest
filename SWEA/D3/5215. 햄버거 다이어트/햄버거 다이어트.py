t = int(input())
for case in range(1, t + 1):
    N, L = map(int, input().split())
    data = [tuple(map(int, input().split())) for _ in range(N)]
    dp = [[0] * (L + 1) for _ in range(N + 1)]
    for i in range(1, N + 1):
        score = data[i - 1][0]
        calorie = data[i - 1][1]
        for j in range(1, L + 1):
            if calorie > j:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - calorie] + score)
    ans = dp[N][L]
    print(f"#{case} {ans}")