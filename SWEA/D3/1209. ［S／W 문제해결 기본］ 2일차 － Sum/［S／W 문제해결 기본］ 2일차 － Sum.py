for case in range(1,11):
    n = int(input())
    board = [list(map(int,input().split())) for _ in range(100)]
    ans = 0
    diagonal1 = 0
    diagonal2 = 0
    for i in range(100):
        diagonal1 += board[i][i]
        diagonal2 += board[i][100-i-1]
        total_row = sum(board[i])
        total_col = 0
        for j in range(100):
            total_col += board[j][i]
        ans = max(ans,total_row,total_col)
    ans = max(ans,diagonal1,diagonal2)    
    print(f"#{n} {ans}")