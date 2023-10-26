from collections import deque

def bfs():     
    dq = deque(point)
    while dq:
        x,y = dq.popleft()
        for dx,dy in ((-1,0),(1,0),(0,-1),(0,1)):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < m:
                if board[nx][ny] == '?' and check[nx][ny] == 0:
                    check[nx][ny] = check[x][y] * -1       
                    dq.append((nx,ny))
                else:
                    if check[nx][ny] == check[x][y]:
                        return False
    return True

t = int(input())
for case in range(1,t+1):
    n,m = map(int,input().split())
    board = [list(input().rstrip()) for _ in range(n)]
    check = [[0] * m for _ in range(n)]
    point = []
    for i in range(n):
        for j in range(m):
            if board[i][j] == '#':
                check[i][j] = 1
                point.append((i,j))
            elif board[i][j] == '.':
                check[i][j] = -1
                point.append((i,j))    
    if bfs():
        print(f'#{case} possible')
    else: 
        print(f'#{case} impossible')