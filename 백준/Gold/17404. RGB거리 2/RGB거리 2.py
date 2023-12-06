from sys import stdin, maxsize
input = stdin.readline

n = int(input())
cost = [list(map(int, input().split())) for _ in range(n)]
total = []
for idx in range(3):
    dp = [[0] * 3 for _ in range(n)]
    for i in range(3):
        dp[0][i] = cost[0][idx]
    for j in range(1, n - 1):
        if j == 1:
            if idx != 0:
                dp[j][0] = min([dp[j - 1][x] for x in (1, 2)]) + cost[j][0]
            else:
                dp[j][0] = maxsize
            if idx != 1:
                dp[j][1] = min([dp[j - 1][x] for x in (0, 2)]) + cost[j][1]
            else:
                dp[j][1] = maxsize
            if idx != 2:
                dp[j][2] = min([dp[j - 1][x] for x in (0, 1)]) + cost[j][2]
            else:
                dp[j][2] = maxsize
        else:
            dp[j][0] = min(dp[j - 1][1], dp[j - 1][2]) + cost[j][0]
            dp[j][1] = min(dp[j - 1][0], dp[j - 1][2]) + cost[j][1]
            dp[j][2] = min(dp[j - 1][0], dp[j - 1][1]) + cost[j][2]
    if idx != 0:
        dp[n - 1][0] = min([dp[n - 2][x] for x in (1, 2)]) + cost[n - 1][0]
    else:
        dp[n - 1][0] = maxsize
    if idx != 1:
        dp[n - 1][1] = min([dp[n - 2][x] for x in (0, 2)]) + cost[n - 1][1]
    else:
        dp[n - 1][1] = maxsize
    if idx != 2:
        dp[n - 1][2] = min([dp[n - 2][x] for x in (0, 1)]) + cost[n - 1][2]
    else:
        dp[n - 1][2] = maxsize
    total.append(min(dp[n - 1]))
print(min(total))
