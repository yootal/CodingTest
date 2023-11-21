from sys import stdin, setrecursionlimit
input = stdin.readline
setrecursionlimit(10**6)

def count(x,y):
    if dp[x][y]:
        return dp[x][y]
    dp[x][y] = 1
    for dx,dy in ((-1,0),(1,0),(0,-1),(0,1)):
        nx = x + dx
        ny = y + dy
        if 0 <= nx < n and 0 <= ny < n:
            if forest[nx][ny] > forest[x][y]: 
                dp[x][y] = max(dp[x][y], count(nx,ny) + 1)
    return dp[x][y]

n = int(input())
forest = [tuple(map(int,input().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]

ans = 0
for i in range(n):
    for j in range(n):
        ans = max(ans,count(i,j))
print(ans)
