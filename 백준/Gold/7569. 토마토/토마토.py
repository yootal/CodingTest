from collections import deque
import sys
input=sys.stdin.readline

dh = [0,0,0,0,1,-1]
dy = [1,-1,0,0,0,0]
dx = [0,0,1,-1,0,0]

n,m,h = map(int,input().split())
board = [[] for _ in range(h)]
for h1 in range(h):
    for _ in range(m):
        board[h1].append(list(map(int,input().split())))
    
start_points = []
for h1 in range(h):
    for m1 in range(m):
        for n1 in range(n):
            if board[h1][m1][n1] == 1:
                start_points.append([h1,m1,n1])
            
def bfs(sp):
    q = deque(sp)
    while q:
        floor,row,col = q.popleft()
        for i in range(6):
            nh = floor + dh[i]
            ny = row + dy[i]
            nx = col + dx[i]
            if nh < 0 or ny < 0 or nx < 0 or nh > h-1 or ny > m-1 or nx > n-1:
                continue
            if board[nh][ny][nx] == 0 and board[nh][ny][nx] != -1:
                board[nh][ny][nx] = board[floor][row][col] + 1 
                q.append((nh,ny,nx))

bfs(start_points)

max_value = 0
check = True

for h2 in range(h):
    for m2 in range(m):
        if 0 in board[h2][m2]:
            check = False
            break
        max_value = max(max_value,max(board[h2][m2]))
    
if check:
    print(max_value-1)
else: print(-1)
