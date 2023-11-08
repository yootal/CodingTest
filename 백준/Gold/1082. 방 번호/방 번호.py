from sys import stdin, maxsize
input = stdin.readline
    
n = int(input())
cost = list(map(int,input().split()))
m = int(input())

dp = [-maxsize for _ in range(m+1)]
for i in range(n-1,-1,-1):
    c = cost[i]
    for j in range(c,m+1):
        dp[j] = max(dp[j], i, dp[j-c] * 10 + i)
        
print(dp[m])
            