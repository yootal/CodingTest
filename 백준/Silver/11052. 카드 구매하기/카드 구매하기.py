import sys 
input = sys.stdin.readline

N = int(input())
card = list(map(int,input().split()))

dp = [0]
dp.extend(card)

for i in range(1,N+1):
    dp[i] = max(dp[j] + dp[i-j] for j in range(1,i+1))

print(dp[N])