import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    coins = list(map(int,input().split()))
    m = int(input())

    dp = [0] * (m+1)
    dp[0] = 1

    for coin in coins:
        for j in range(coin,m+1):
            dp[j] += dp[j - coin]

    print(dp[m])
    