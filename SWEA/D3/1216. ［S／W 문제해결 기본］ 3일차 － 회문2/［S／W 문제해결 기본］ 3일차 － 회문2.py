for case in range(1,11):
    n = int(input())
    board = [list(input().rstrip()) for _ in range(100)]
    ans = 0
    
    for i in range(100):
        for j in range(100):
            for k in range(j,100):
                word = ""
                for l in range(j,k+1):
                    word += board[i][l]
                if word == word[::-1]:
                    ans = max(ans,len(word))
                 
    for i in range(100):
        for j in range(100):
            for k in range(j,100):
                word = ""
                for l in range(j,k+1):
                    word += board[l][i]
                if word == word[::-1]:
                    ans = max(ans,len(word))
             
    print(f"#{case} {ans}")