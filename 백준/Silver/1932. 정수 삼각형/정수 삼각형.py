import sys 
input = sys.stdin.readline

inp = int(input())

dp = []

for _ in range(inp):
    dp.append(list(map(int,input().split())))

for i in range(1,inp):
    for j in range(len(dp[i])):
        if j == 0:
            dp[i][j] = dp[i][j] + dp[i-1][j]
        elif j==len(dp[i])-1:
            dp[i][j] = dp[i][j] + dp[i-1][j-1]
        else:
            dp[i][j] = max(dp[i-1][j-1],dp[i-1][j]) + dp[i][j]

print(max(dp[inp-1]))
        


    

            
        