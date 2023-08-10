import sys
input=sys.stdin.readline
from collections import deque

# 0북 1동 2남 3서
dx,dy = [-1,0,1,0],[0,1,0,-1]

N = int(input())
K = int(input())
apple = [list(map(lambda x: int(x)-1,input().split())) for _ in range(K)]
L = int(input())
command = deque(list(input().rstrip().split()) for _ in range(L))

board = [[0] * N for _ in range(N)]
for a in apple:
    board[a[0]][a[1]] = 1

time = 0
q = deque([(0,0,1)])
snake = deque([(0,0)])

while q:
    time += 1
    x,y,d = q.popleft()
    nx = x + dx[d]
    ny = y + dy[d]
    if nx < 0 or nx > N-1 or ny < 0 or ny > N-1 or board[nx][ny] == 2:
        break
    snake.append((nx,ny))
    if board[nx][ny] == 1: # 사과
        board[nx][ny] = 2
    elif board[nx][ny] == 0: # 빈칸
        board[nx][ny] = 2
        sx,sy = snake.popleft()
        board[sx][sy] = 0   
    
    if len(command) > 0 and time == int(command[0][0]):
        t, c = command.popleft()
        if c == 'D':
            d = (d + 1) % 4
        elif c == 'L':
            d -= 1
            if d < 0:
                d += 4 
        q.append((nx,ny,d))
    else:
        q.append((nx,ny,d))

print(time)