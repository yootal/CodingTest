t = int(input())
for case in range(1,t+1):
    n,l = map(int,input().split())
    material = [tuple(map(int,input().split())) for _ in range(n)]
    dp = [[0] * (l+1) for _ in range(n+1)]

    for i in range(1,n+1):
        for j in range(1,l+1):
            prefer = material[i-1][0]
            calorie = material[i-1][1]
            if j < calorie:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(prefer + dp[i-1][j-calorie],dp[i-1][j])  
                  
    print(f"#{case} {dp[n][l]}")