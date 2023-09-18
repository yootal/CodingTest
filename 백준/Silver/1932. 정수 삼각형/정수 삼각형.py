import sys 
input = sys.stdin.readline

n = int(input())
num = [[] for _ in range(n+1)]

for i in range(1,n+1):
    num[i] = [0] + list(map(int,input().split()))
    
dp = [[0] * (n+1) for _ in range(n+1)]
dp[1][1] = num[1][1]

for i in range(2,n+1):
    for j in range(1,i+1):
        if j == 1:
            dp[i][j] = dp[i-1][j] + num[i][j]
        elif j == i:
            dp[i][j] = dp[i-1][j-1] + num[i][j]
        else:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + num[i][j]
            
print(max(dp[i]))