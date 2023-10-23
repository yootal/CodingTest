d = [(-1,-1),(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1)]
t = int(input())
for case in range(1,t+1):
    n,m = map(int,input().split())
    board = [[0] * n for _ in range(n)]
    center = (n-1)//2
    for i in range(center,center+2):
        for j in range(center,center+2):
            if (i + j) % 2 == 0:
                board[i][j] = 2
            else:
                board[i][j] = 1 
    for _ in range(m):
        x,y,stone = map(int,input().split())
        x -= 1
        y -= 1
        board[x][y] = stone
        for i in range(8):
            nx = x + d[i][0]
            ny = y + d[i][1]
            if 0 > nx or 0 > ny or nx > n-1 or ny > n-1:
                continue
            if board[nx][ny] == stone or board[nx][ny] == 0:
                continue  
            while True:
                nx += d[i][0]
                ny += d[i][1]
                if 0 > nx or 0 > ny or nx > n-1 or ny > n-1:
                    break
                if board[nx][ny] == 0:
                    break
                if board[nx][ny] == stone:
                    while True:
                        nx -= d[i][0]
                        ny -= d[i][1]
                        if nx == x and ny == y:
                            break
                        board[nx][ny] = stone                        
                    break
    cnt1 = 0
    cnt2 = 0
    for row in board:
        for base in row:
            if base == 1:
                cnt1 += 1
            elif base == 2:
                cnt2 += 1
                
    print(f"#{case} {cnt1} {cnt2}")
    