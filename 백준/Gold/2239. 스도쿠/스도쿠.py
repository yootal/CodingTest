import sys
input = sys.stdin.readline

board = [[int(num) for num in input().rstrip()] for _ in range(9)]
empty_space = [(i, j) for i in range(9) for j in range(9) if board[i][j] == 0]

def possible_num(i, j):
    promising = [1,2,3,4,5,6,7,8,9] 
    for k in range(9):
        if board[i][k] in promising: # 가로
            promising.remove(board[i][k])
        if board[k][j] in promising: # 세로
            promising.remove(board[k][j])
            
    i //= 3
    j //= 3
    
    for p in range(i*3, (i+1)*3):
        for q in range(j*3, (j+1)*3):
            if board[p][q] in promising:
                promising.remove(board[p][q])
    
    return promising

check = False 

def sudoku(x):
    global check
        
    if x == len(empty_space): # 다 채웠을 때
        for row in board:
            for num in row:
                print(num,end="")
            print()
        exit()
        
    else:    
        (i, j) = empty_space[x]
        promising = possible_num(i, j) # 가능한 숫자
        for num in promising:
            board[i][j] = num 
            sudoku(x + 1) 
            board[i][j] = 0 
            
sudoku(0)