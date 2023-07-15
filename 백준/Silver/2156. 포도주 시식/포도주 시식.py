import sys 
input = sys.stdin.readline

inp = int(input())

dp = [0 for _ in range(inp)]
wine = []
for _ in range(inp):
    wine.append(int(input()))
    
    
dp[0] = wine[0]
if inp > 1:
    dp[1] = wine[0] + wine[1]
if inp > 2:
    dp[2] = max(wine[2]+wine[1],wine[2]+wine[0],dp[1])
for i in range(3,inp):
    dp[i] = max(dp[i-2]+wine[i],dp[i-3]+wine[i-1]+wine[i],dp[i-1])

print(dp[inp-1])   