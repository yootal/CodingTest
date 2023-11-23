import sys
input = sys.stdin.readline

n,p,q,x,y = map(int,input().split())
dp = {}
dp[0] = 1

def dfs(n):
    if n < 0:
        return 1
    if n in dp:
        return dp[n]
    else:
        dp[n] = dfs(n//p-x) + dfs(n//q-y)
        return dp[n]

print(dfs(n))