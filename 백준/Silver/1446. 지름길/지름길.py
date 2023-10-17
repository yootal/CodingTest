from sys import stdin
input = stdin.readline

n,d = map(int,input().split())
path = [tuple(map(int,input().split())) for _ in range(n)]
dp = [i for i in range(d+1)]
for i in range(d+1):
    if i > 0:
        dp[i] = min(dp[i],dp[i-1]+1)
    for s,e,c in path:
        if i == s and e <= d and dp[i] + c < dp[e]:
            dp[e] = dp[i] + c

print(dp[d])