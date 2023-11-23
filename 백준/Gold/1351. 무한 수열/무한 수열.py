import sys
input = sys.stdin.readline

n,p,q = map(int,input().split())
dp = {}
dp[0] = 1

def dfs(n):
    if n in dp:
        return dp[n]
    else:
        dp[n] = dfs(n//p) + dfs(n//q)
        return dp[n]

print(dfs(n))