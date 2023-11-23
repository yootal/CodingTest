from sys import stdin
input = stdin.readline

n = int(input())
w = list(map(int, input().split()))
n2 = int(input())
w2 = list(map(int, input().split()))
max_weight = sum(w)

dp = [[False] * (max_weight + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    weight = w[i - 1]
    dp[i][weight] = True
    for j in range(1, max_weight + 1):
        if dp[i - 1][j]:
            dp[i][j] = True
            if j < weight:
                dp[i][weight - j] = True
            else:
                dp[i][j - weight] = True
        if j >= weight and dp[i - 1][j - weight]:
            dp[i][j] = True

for i in w2:
    if i > max_weight or not dp[n][i]:
        print('N', end=' ')
    else:
        print('Y', end=' ')