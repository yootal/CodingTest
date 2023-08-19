import sys 
input = sys.stdin.readline

T = int(input())
TC = [int(input()) for _ in range(T)]
dp = [0] * 1000000
dp[0] = 1
dp[1] = 2
dp[2] = 4
for i in range(3,1000000):
    dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009
for c in TC:
    print(dp[c-1])