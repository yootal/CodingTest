import sys
input=sys.stdin.readline

n,w = map(int,input().split())

things = [[0,0]]
dp = [[0]*(w+1) for _ in range(n+1)]

for _ in range(n):
    things.append(list(map(int,input().split())))

for i in range(n+1):
    for j in range(w+1):
        weight = things[i][0]
        value = things[i][1]
        
        if j < weight:
            dp[i][j] = dp[i-1][j]
        else: 
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight]+value)
                
print(dp[n][w])