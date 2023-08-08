import sys
input=sys.stdin.readline
import copy

# cctv 방향 정보
mode = [[[0],[1],[2],[3]],
        [[0,2],[1,3]],
        [[0,1],[1,2],[2,3],[0,3]],
        [[0,1,2],[0,1,3],[1,2,3],[0,2,3]],
        [[0,1,2,3]]]

# 방향 맞춰 줘야 함
dx = [-1,0,1,0]
dy = [0,1,0,-1]

n,m = map(int,input().split())

board = []
cctv = []
min_value = 0
for i in range(n):
    data = list(map(int,input().split()))
    min_value += data.count(0)
    board.append(data)
    for j in range(m):
        if data[j] in [1,2,3,4,5]:
            cctv.append([data[j],i,j])

def watch(board, mode, x, y):
    for i in mode:
        nx = x
        ny = y
        while True:
            nx += dx[i]
            ny += dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                break
            if board[nx][ny] == 6:
                break
            elif board[nx][ny] == 0:
                board[nx][ny] = 7

def dfs(depth, board):
    global min_value
    if depth == len(cctv):
        count = 0
        for i in range(n):
            count += board[i].count(0)
        min_value = min(min_value, count)
        return
    
    temp = copy.deepcopy(board)
    cctv_num, x, y = cctv[depth]
    for i in mode[cctv_num-1]:
        watch(temp,i,x,y)
        dfs(depth+1, temp)
        temp = copy.deepcopy(board)
        
dfs(0,board)
print(min_value)
 