import sys 
input = sys.stdin.readline

n = int(input())
dp = [[0] * 3 for _ in range(n+1)]
rgb = [[]]

for _ in range(n):
    rgb.append(list(map(int,input().split())))
    
dp[1][0] = rgb[1][0]
dp[1][1] = rgb[1][1]
dp[1][2] = rgb[1][2]


for i in range(2,n+1):
    dp[i][0] = min(dp[i-1][1],dp[i-1][2]) + rgb[i][0]
    dp[i][1] = min(dp[i-1][0],dp[i-1][2]) + rgb[i][1]
    dp[i][2] = min(dp[i-1][0],dp[i-1][1]) + rgb[i][2]

print(min(dp[n]))