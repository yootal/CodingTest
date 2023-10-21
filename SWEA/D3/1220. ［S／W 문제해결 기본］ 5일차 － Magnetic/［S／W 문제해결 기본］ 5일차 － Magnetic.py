for case in range(1,11):
    n = int(input())
    board = [list(map(int,input().split())) for _ in range(n)]
    ans = 0
    
    for i in range(100):
        pre = 2
        check = 2
        for j in range(100):
            if board[j][i] != 0 and board[j][i] != pre:
                pre = board[j][i]
                if check == pre:
                    ans += 1
            
    print(f"#{case} {ans}")