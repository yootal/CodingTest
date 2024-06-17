import sys
input=sys.stdin.readline

n,m = map(int,input().split())
senior = [0] + list(map(int,input().split()))

dp = [0] * (n+1)
for _ in range(m):
    i,w = map(int,input().split())
    dp[i] += w

for i in range(1,n+1):
    if senior[i] != -1:
        dp[i] += dp[senior[i]]
print(*dp[1:])
