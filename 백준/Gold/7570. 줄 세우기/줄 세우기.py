import sys
input = sys.stdin.readline

n = int(input())
num = list(map(int,input().split()))
dp = [0] * (n+1)

max_chain = 0 # 최대 연속
for i in range(n):
    dp[num[i]] = dp[num[i] - 1] + 1
    max_chain = max(max_chain,dp[num[i]])
    
print(n - max_chain)