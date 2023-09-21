import sys
inf = sys.maxsize
input = sys.stdin.readline

n = int(input())
dp = [0] * (31)

if n % 2 == 1:
    print(0)
    
else:
    dp[0] = 1
    dp[2] = 3
    for i in range(3,n+1):
        dp[i] += dp[i-2] * 3
        for j in range(i-4,-1,-2):
            dp[i] += dp[j] * 2
    
    print(dp[n])
