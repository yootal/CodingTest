from sys import stdin
from collections import deque
input = stdin.readline

n,m = map(int,input().split())
board = []
doyeon = None
for i in range(n):
    inp = list(input().rstrip())
    for j in range(m):
        if inp[j] == 'I':
            doyeon = (i,j)
    board.append(inp)
            
ans = 0
vis = [[False] * m for _ in range(n)]
dq = deque([doyeon])
vis[doyeon[0]][doyeon[1]] = True
while dq:
    x,y = dq.popleft()
    if board[x][y] == 'P':
        ans += 1
    for dx,dy in ((-1,0),(1,0),(0,-1),(0,1)):
        nx = x + dx
        ny = y + dy
        if 0 <= nx < n and 0 <= ny < m:
            if board[nx][ny] != 'X' and not vis[nx][ny]:
                vis[nx][ny] = True
                dq.append((nx,ny))
                
print(ans if ans != 0 else 'TT')