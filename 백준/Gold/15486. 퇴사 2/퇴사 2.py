import sys 
input = sys.stdin.readline

N = int(input())
S = []
for i in range(N):
    T,P = map(int,input().split())
    S.append([T,P])
dp = [0] * (N+1)
max_value = 0
for i in range(N):
    max_value = max(max_value,dp[i])
    if i + S[i][0] > N:
        continue
    dp[i+S[i][0]] = max(max_value + S[i][1], dp[i+S[i][0]])

print(max(dp))