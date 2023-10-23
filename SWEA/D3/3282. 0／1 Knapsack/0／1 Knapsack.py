t = int(input())
for case in range(1,t+1):
    n,k = map(int,input().split())
    things = []
    for _ in range(n):
        v,c = map(int,input().split())
        things.append((v,c))
    dp = [[0] * (k+1) for _ in range(n+1)]
    for i in range(1,n+1):
        for j in range(1,k+1):
            volume = things[i-1][0]
            cost = things[i-1][1]
            if j < volume:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-volume] + cost)
    print(f"#{case} {dp[n][k]}")