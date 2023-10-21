for case in range(1,11):
    n = int(input())
    board = [list(input().rstrip()) for _ in range(8)]
    ans = 0
    
    for i in range(8):
        for j in range(8-n+1):
            word = ""
            for k in range(j,j+n):
                word += board[i][k]
            if word == word[::-1]:
                ans += 1
                
    for i in range(8):
        for j in range(8-n+1):
            word = ""
            for k in range(j,j+n):
                word += board[k][i]
            if word == word[::-1]:
                ans += 1
            
    print(f"#{case} {ans}")