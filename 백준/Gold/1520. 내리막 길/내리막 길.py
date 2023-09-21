import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]

n,m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
dp = [[-1] * m for _ in range(n)]

def dfs(x,y):
    if dp[x][y] != -1:
        return dp[x][y]
    
    if x == n-1 and y == m-1:
        return 1
    
    dp[x][y] = 0
    for dx,dy in d:
        nx = x + dx
        ny = y + dy
        if 0 > nx or n <= nx or 0 > ny or m <= ny:
            continue
        if board[x][y] > board[nx][ny]:
            dp[x][y] += dfs(nx,ny)
            
    return dp[x][y]
            
print(dfs(0,0))