import sys
input=sys.stdin.readline
from collections import deque

dx,dy,dz = [-1,1,0,0,0,0],[0,0,-1,1,0,0],[0,0,0,0,-1,1]

def find_min_bfs(board_num,board_rotate_num):
    global min_value
    newboard = []
    for i in range(5):
        newboard.append(board[board_num[i]][board_rotate_num[i]])
    if newboard[0][0][0] == 1 and newboard[4][4][4] == 1:
        visited = [[[0] * 5 for _ in range(5)] for _ in range(5)]
        q = deque()
        q.append((0,0,0))
        visited[0][0][0] = 1
        while q:
            x,y,z = q.popleft()
            if x == 4 and y == 4 and z == 4:
                min_value = min(min_value,visited[x][y][z])
                return
            for i in range(6):
                nx = x + dx[i]
                ny = y + dy[i]
                nz = z + dz[i]
                if 0 <= nx < 5 and 0 <= ny < 5 and 0 <= nz < 5:
                    if newboard[nx][ny][nz] == 1 and visited[nx][ny][nz] == 0:
                        visited[nx][ny][nz] = visited[x][y][z] + 1
                        q.append((nx,ny,nz))
    return

def find_min_backT(board_num,board_rotate_num):
    if len(board_num) == 5:
        find_min_bfs(board_num,board_rotate_num)
        return
    for i in range(5):
        if i not in board_num:
            board_num.append(i)
            for j in range(len(board[i])):
                board_rotate_num.append(j)
                find_min_backT(board_num,board_rotate_num)
                board_rotate_num.pop()
            board_num.pop()
    return

def rotate(n,insert_board):
    for c in range(3):
        newboard = [[0] * 5 for _ in range(5)]
        for i in range(5):
            for j in range(5):
                newboard[j][4-i] = insert_board[i][j]  
        if c == 0 and insert_board == newboard:
            return  
        else:
            board[n].append(newboard)
            insert_board = newboard 
    return

board = [[],[],[],[],[]]
for i in range(5):
    insert_board = [list(map(int,input().split())) for _ in range(5)]
    board[i].append(insert_board)
    rotate(i,insert_board)
    
min_value = sys.maxsize
find_min_backT([],[])
    
if min_value == sys.maxsize:
    print(-1)
else:
    print(min_value - 1)