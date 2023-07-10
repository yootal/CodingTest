board = [list(map(int, input().split())) for _ in range(9)]
empty_space = [(i, j) for i in range(9) for j in range(9) if board[i][j] == 0]

def is_promising(i, j):
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
    
    if check: # 이미 답이 출력된 경우
        return
        
    if x == len(empty_space): # 마지막 0까지 다 채웠을 경우
        for row in board:
            print(*row)
        check = True # 답 출력
        return
        
    else:    
        (i, j) = empty_space[x]
        promising = is_promising(i, j) # 유망한 숫자들을 받음
        
        for num in promising:
            board[i][j] = num #유망한 숫자 중 하나를 넣어줌
            sudoku(x + 1) # 다음 0으로 넘어감
            board[i][j] = 0 # 초기화 (정답이 없을 경우를 대비)
            
sudoku(0)