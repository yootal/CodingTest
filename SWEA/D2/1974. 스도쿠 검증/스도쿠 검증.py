t  = int(input())
for case in range(1,t+1):
    board = [list(map(int,input().split())) for _ in range(9)]
    
    flag = True
    
    for i in range(9):
        if not flag:
            break
        cnt = [0,0,0,0,0,0,0,0,0]
        for j in range(9):
            cnt[board[i][j]-1] += 1
        for c in cnt:
            if c != 1:
                flag = False
                break
    
    for i in range(9):
        if not flag:
            break
        cnt = [0,0,0,0,0,0,0,0,0]
        for j in range(9):
            cnt[board[j][i]-1] += 1
        for c in cnt:
            if c != 1:
                flag = False
                break
    
    for i in range(0,9,3):
        if not flag:
            break
        for j in range(0,9,3):
            if not flag:
                break
            cnt = [0,0,0,0,0,0,0,0,0]
            for i2 in range(i,i+3):
                for j2 in range(j,j+3):
                    cnt[board[i2][j2]-1] += 1
            for c in cnt:
                if c != 1:
                    flag = False
                    break
    
    if flag:
        print(f"#{case} 1")
    else:
        print(f"#{case} 0")