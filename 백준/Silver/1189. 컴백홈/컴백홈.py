from sys import stdin
input = stdin.readline

n,m,k = map(int,input().split())
board = [list(input().rstrip()) for _ in range(n)]

def dfs(x,y,d):
    global ans
    if x == 0 and y == m-1 and d == k:
        ans += 1
    else:
        board[x][y] = 'T'
        for dx,dy in [(-1,0),(1,0),(0,-1),(0,1)]:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == '.':
                board[nx][ny] = 'T'
                dfs(nx,ny,d+1)
                board[nx][ny] = '.'

ans = 0
dfs(n-1,0,1)
print(ans)      