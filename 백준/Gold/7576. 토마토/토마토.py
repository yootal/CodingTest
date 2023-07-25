from collections import deque
import sys
input=sys.stdin.readline

dy = [1,-1,0,0]
dx = [0,0,1,-1]

n,m = map(int,input().split())
board = []
for _ in range(m):
    board.append(list(map(int,input().split())))
    
start_points = []
    
for m1 in range(m):
    for n1 in range(n):
        if board[m1][n1] == 1:
            start_points.append([m1,n1])
            
def bfs(sp):
    q = deque(sp)
    while q:
        row,col = q.popleft()
        for i in range(4):
            ny = row + dy[i]
            nx = col + dx[i]
            if ny < 0 or nx < 0 or ny > m-1 or nx > n-1:
                continue
            if board[ny][nx] == 0 and board[ny][nx] != -1:
                board[ny][nx] = board[row][col] + 1 
                q.append((ny,nx))

bfs(start_points)

max_value = 0
check = True

for b in board:
    if 0 in b:
        print(-1)
        check = False
        break
    max_value = max(max_value,max(b))
    
if check:
    print(max_value-1)
