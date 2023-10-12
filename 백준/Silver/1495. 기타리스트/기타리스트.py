from sys import stdin
input = stdin.readline

n,s,m = map(int,input().split())
vol = list(map(int,input().split()))

dp = [[0] * (m+1) for _ in range(n+1)]
dp[0][s] = 1

for i in range(n):
    for j in range(m+1):
        if dp[i][j] == 1:
            if j + vol[i] <= m:
                dp[i+1][j+vol[i]] = 1
            if j - vol[i] >= 0:
                dp[i+1][j-vol[i]] = 1
                
for i in range(m,-1,-1):
    if dp[n][i] == 1:
        print(i)
        exit()
print(-1)
    