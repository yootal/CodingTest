import sys
input = sys.stdin.readline

n = int(input())
cand = (1,3,4)

dp = [-1] * 1001
dp[1] = 0
dp[2] = 1
dp[3] = 0
dp[4] = 0

for i in range(5,n+1):
    for j in cand:
        if dp[i-j] == 1:
            dp[i] = 0
            break
        else:
            dp[i] = 1
        
print("CY" if dp[n] == 1 else "SK")