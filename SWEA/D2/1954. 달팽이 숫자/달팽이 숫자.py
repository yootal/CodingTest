t = int(input())

d = [(0,1),(1,0),(0,-1),(-1,0)]

def limit(i,j):
    return i < 0 or i >= n or j < 0 or j >= n

def snail(i,j,dir,st):
    while True:
        board[i][j] = st
        if st == n**2:
            return
        ni = i + d[dir][0]
        nj = j + d[dir][1]
        if limit(ni,nj) or board[ni][nj] != 0:
            snail(i + d[(dir+1)%4][0], j + d[(dir+1)%4][1], (dir+1)%4, st+1)
            return
        i = ni
        j = nj
        st += 1
                
for i in range(1,t+1):
    n = int(input())
    board = [[0] * n for _ in range(n)]
    snail(0,0,0,1)
    
    print(f"#{i}")
    for b in board:
        print(*b)
