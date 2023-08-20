import sys
input=sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    coin = list(map(int,input().split()))
    sum = int(input())
    dp = [0] * (sum + 1)
    dp[0] = 1
    
    for i in coin:
        for j in range(i, sum + 1):
            if j - i >= 0:
                dp[j] += dp[j-i]
    
    print(dp[sum])