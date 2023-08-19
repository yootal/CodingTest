import sys 
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    S = []
    for _ in range(2):
        S.append(list(map(int,input().split())))
    dp = [[0] * 2 for _ in range(N+1)]

    for i in range(1,N+1):
        if i > 2:
            dp[i][0] = max(dp[i-2][1], dp[i-1][1]) + S[0][i-1]
            dp[i][1] = max(dp[i-2][0], dp[i-1][0]) + S[1][i-1]
        else:
            dp[i][0] = dp[i-1][1] + S[0][i-1]
            dp[i][1] = dp[i-1][0] + S[1][i-1]
    print(max(dp[N]))