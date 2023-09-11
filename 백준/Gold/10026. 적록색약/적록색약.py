import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

dy = [1,-1,0,0]
dx = [0,0,1,-1]

n = int(input())
board = [input().rstrip() for _ in range(n)]
vis1 = [[False] * n for _ in range(n)]
vis2 = [[False] * n for _ in range(n)]

def dfs(x,y,c):
    vis1[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx <= n-1 and 0 <= ny <= n-1:
            if board[nx][ny] == c and not vis1[nx][ny]:
                dfs(nx,ny,c)
                
def dfs_cw(x,y,c):
    vis2[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx <= n-1 and 0 <= ny <= n-1:
            if c == 'R' or c == 'G':
                if (board[nx][ny] == 'R' or board[nx][ny] == 'G') and not vis2[nx][ny]:
                    dfs_cw(nx,ny,c)
            else:
                if board[nx][ny] == c and not vis2[nx][ny]:
                    dfs_cw(nx,ny,c)
                
cnt = 0                
cnt_cw = 0
for i in range(n):
    for j in range(n):
        if not vis1[i][j]:
            dfs(i,j,board[i][j])
            cnt += 1
        if not vis2[i][j]:
            dfs_cw(i,j,board[i][j])
            cnt_cw += 1
            
print(cnt,cnt_cw)