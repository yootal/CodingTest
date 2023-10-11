from sys import setrecursionlimit
setrecursionlimit(10**6)

d = [(1,0),(0,1),(-1,0),(0,-1)]

def limit(i,j):
    return i < 0 or i >= n or j < 0 or j >= n

def snail(i,j,dir,st):
    global ans
    while True:
        if st == m:
            ans = (i+1,j+1)
        board[i][j] = st
        if st == 1:
            return
        ni = i + d[dir][0]
        nj = j + d[dir][1]
        if limit(ni,nj) or board[ni][nj] != 0:
            snail(i + d[(dir+1)%4][0], j + d[(dir+1)%4][1], (dir+1)%4, st-1)
            return
        i = ni
        j = nj
        st -= 1
                
n = int(input())
m = int(input())
board = [[0] * n for _ in range(n)]

ans = (0,0)
snail(0,0,0,n**2)

for b in board:
    print(*b)
print(*ans)
    