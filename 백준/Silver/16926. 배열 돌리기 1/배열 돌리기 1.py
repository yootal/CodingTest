from sys import stdin
input = stdin.readline

n,m,r = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]

for _ in range(r):
    for i in range(min(n,m)//2):
        temp = board[i][i]
        for i1 in range(i,m-i-1):
            board[i][i1] = board[i][i1+1]
        for i2 in range(i,n-i-1):
            board[i2][m-1-i] = board[i2+1][m-1-i]
        for i3 in range(m-1-i,i,-1):
            board[n-1-i][i3] = board[n-1-i][i3-1]
        for i4 in range(n-1-i,1+i,-1):
            board[i4][i] = board[i4-1][i]
        board[i+1][i] = temp

for b in board: 
    print(*b)
        