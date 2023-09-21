import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
mod = 1e9 + 3

dp = [[0] * (k+1) for _ in range(n+1)] # i개의 색 중 j개의 색 선택 경우의 수

for i in range(1,n+1):
    dp[i][1] = i # i개중 1개 선택 : i가지 경우
    
for i in range(4,n+1):
    for j in range(2,k+1):
        if j > i / 2: # 초과 선택
            break
        # i-1개중 j개 선택 + n번째 색 선택 X
        # i-2개중 j-1개 선택 + n번째 색 선택 O
        dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % mod

print(int(dp[n][k]))