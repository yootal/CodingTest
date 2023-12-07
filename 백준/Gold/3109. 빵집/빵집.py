from sys import stdin
input = stdin.readline

d = [(-1,1),(0,1),(1,1)]
r,c = map(int,input().split())
board = [list(input().rstrip()) for _ in range(r)]
vis = [[False] * c for _ in range(r)]

def dfs(x,y):
    if y == c-1:
        return True
    for dx,dy in d:
        nx = x + dx
        ny = y + dy
        if 0 <= nx < r and 0 <= ny < c:
            if board[nx][ny] != 'x' and not vis[nx][ny]:
                vis[nx][ny] = True
                if dfs(nx,ny):
                    return True
    return False

ans = 0 
for row in range(r):
    if dfs(row,0):
        ans += 1
print(ans)