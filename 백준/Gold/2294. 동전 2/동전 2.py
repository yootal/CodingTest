import sys
inf = sys.maxsize
input = sys.stdin.readline

n,k = map(int,input().split())
coins = [int(input()) for _ in range(n)]
coins.sort()

dp = [inf] * (k+1)
dp[0] = 0

for i in range(1,k+1):
    for coin in coins:
        if i - coin < 0:
            break
        dp[i] = min(dp[i], 1 + dp[i-coin])
        
if dp[k] == inf:
    print(-1)
else:
    print(dp[k])