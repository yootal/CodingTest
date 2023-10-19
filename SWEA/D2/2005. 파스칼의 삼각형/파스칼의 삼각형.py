t  = int(input())
for case in range(1,t+1):
    n = int(input())
    board = []
    
    for i in range(1,n+1):
        board.append([0]*i)
        
    board[0][0] = 1
    for i in range(2,n+1):
        for j in range(i):
            if j == 0:
                board[i-1][j] = board[i-2][0]
            elif j == i-1:
                board[i-1][j] = board[i-2][-1]
            else:
                board[i-1][j] = board[i-2][j-1] + board[i-2][j]
                
    print(f"#{case}")
    for b in board:
        print(*b)