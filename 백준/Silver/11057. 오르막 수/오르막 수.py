import sys 
input = sys.stdin.readline

N = int(input())
dp = [[0,0,0,0,0,0,0,0,0,0] for _ in range(1001)]
dp[1] = [1,1,1,1,1,1,1,1,1,1]
if N == 1:
    print(sum(dp[1]))
else:
    for i in range(2,N+1):
        for j in range(10):
            dp[i][j] += sum(dp[i-1][:(j+1)])
    print(sum(dp[N]) % 10007)