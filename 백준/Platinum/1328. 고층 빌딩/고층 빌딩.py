from sys import stdin
input = stdin.readline

N,L,R = map(int,input().split())
mod = 1000000007

dp = [[[0 for _ in range(N+1)] for _ in range(N+1)] for _ in range(N+1)]
dp[1][1][1] = 1 # 좌, 우 에서 한개 = 빌딩 하나

for h in range(2,N+1):
    for l in range(1,L+1):
        for r in range(1,R+1):
            # 좌측에 높이1 추가 + 우측에 높이1 추가 + 원래 있던 빌딩 사이에 추가
            dp[h][l][r] = ((dp[h-1][l-1][r] + dp[h-1][l][r-1] + dp[h-1][l][r] * (h-2)) % mod)
            
print(dp[N][L][R])