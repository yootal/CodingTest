import sys
input=sys.stdin.readline
import copy

def dfs(cnt,board):
    global max_value
    if cnt == 5:
        for b in board:
            max_value = max([max_value] + b)
        return
    for i in range(4):
        if i == 0:
            # 위
            board2 = copy.deepcopy(board)
            dfs(cnt + 1, up(board2))
        elif i == 1:
            # 오른쪽
            board2 = copy.deepcopy(board)
            dfs(cnt + 1, right(board2))
        elif i == 2:
            # 아래
            board2 = copy.deepcopy(board)
            dfs(cnt + 1, down(board2))
        else:
            # 왼쪽
            board2 = copy.deepcopy(board)
            dfs(cnt + 1, left(board2))

def up(board):
    up_pull(board)
    for col in range(n):
        for row in range(n-1):
            if board[row][col] == board[row+1][col]:
                board[row][col] *= 2
                for row2 in range(row+1,n-1):
                    board[row2][col] = board[row2+1][col]
                board[n-1][col] = 0

    return board

def up_pull(board):
    num = [[] for _ in range(n)]
    for col in range(n):
        for row in range(n):
            if board[row][col] != 0:
                num[col].append(board[row][col])
                board[row][col] = 0
    for col in range(n):
        for row in range(len(num[col])):
            board[row][col] = num[col][row]
    
def right(board):
    right_pull(board)
    for row in range(n):
        for col in range(n-1,0,-1):
            if board[row][col] == board[row][col-1]:
                board[row][col] *= 2
                for col2 in range(col-1,0,-1):
                    board[row][col2] = board[row][col2-1]
                board[row][0] = 0
    return board

def right_pull(board):
    num = [[] for _ in range(n)]
    for row in range(n):
        for col in range(n):
            if board[row][col] != 0:
                num[row].append(board[row][col])
                board[row][col] = 0
    for row in range(n):
        for col in range(n-1,n-len(num[row])-1,-1):
            board[row][col] = num[row].pop()
    
def down(board):
    down_pull(board)
    for col in range(n):
        for row in range(n-1,0,-1):
            if board[row][col] == board[row-1][col]:
                board[row][col] *= 2
                for row2 in range(row-1,0,-1):
                    board[row2][col] = board[row2-1][col]
                board[0][col] = 0

    return board
    
def down_pull(board):
    num = [[] for _ in range(n)]
    for col in range(n):
        for row in range(n):
            if board[row][col] != 0:
                num[col].append(board[row][col])
                board[row][col] = 0
    for col in range(n):
        for row in range(n-1,n-len(num[col])-1,-1):
            board[row][col] = num[col].pop()
            
def left(board):
    left_pull(board)
    for row in range(n):
        for col in range(n-1):
            if board[row][col] == board[row][col+1]:
                board[row][col] *= 2
                for col2 in range(col+1,n-1):
                    board[row][col2] = board[row][col2+1]
                board[row][n-1] = 0
    return board

def left_pull(board):
    num = [[] for _ in range(n)]
    for row in range(n):
        for col in range(n):
            if board[row][col] != 0:
                num[row].append(board[row][col])
                board[row][col] = 0
    for row in range(n):
        for col in range(len(num[row])):
            board[row][col] = num[row][col]

n = int(input())
board = [list(map(int,input().split())) for _ in range(n)]
max_value = 0

dfs(0, board)
print(max_value)