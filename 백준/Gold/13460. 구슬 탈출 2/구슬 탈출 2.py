import sys
input = sys.stdin.readline
from collections import deque

dx,dy = [-1,1,0,0],[0,0,-1,1]

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]

q = deque() 
visited = [[[[False] * M for _ in range(N)] for _ in range(M)] for _ in range(N)]

rx, ry, bx, by = 0, 0, 0, 0
for i in range(N):
    for j in range(M):
        if board[i][j] == 'R':
            rx, ry = i, j
        elif board[i][j] == 'B':
            bx, by = i, j 

q.append((rx,ry,bx,by,1))
visited[rx][ry][bx][by] = True

def move(x, y, dx, dy):
    move_count = 0
    while board[x+dx][y+dy] != '#' and board[x][y] != 'O':
        x += dx
        y += dy
        move_count += 1
    return x,y,move_count
 
while q:
    rx2,ry2,bx2,by2,depth = q.popleft()
    if depth > 10:
        break
    for i in range(4):
        nrx, nry, rcnt = move(rx2, ry2, dx[i], dy[i])
        nbx, nby, bcnt = move(bx2, by2, dx[i], dy[i])
        
        if board[nbx][nby] != 'O': # 실패가 아니면
            if board[nrx][nry] == 'O':
                print(depth)
                exit()
            if nrx == nbx and nry == nby: # 겹쳤을 때
                if rcnt > bcnt:
                    nrx -= dx[i]
                    nry -= dy[i]
                else:
                    nbx -= dx[i]
                    nby -= dy[i]
            if not visited[nrx][nry][nbx][nby]:
                visited[nrx][nry][nbx][nby] = True   
                q.append((nrx,nry,nbx,nby,depth + 1))       
print(-1) 