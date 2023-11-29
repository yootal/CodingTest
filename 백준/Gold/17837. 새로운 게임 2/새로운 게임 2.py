from sys import stdin
from collections import defaultdict
input = stdin.readline

dir = [(0,1),(0,-1),(-1,0),(1,0)]

def move(i,check):
    global turn
        
    r,c,d = info[i]
    idx = state[(r,c)].index(i)
    nr = r + dir[d-1][0]
    nc = c + dir[d-1][1]
    
    if 1 <= nr < n+1 and 1 <= nc < n+1:
        if board[nr-1][nc-1] == 0:
            block = state[(r,c)][idx:]
            for x in block:
                info[x][0] = nr
                info[x][1] = nc
            state[(nr,nc)].extend(block)
            state[(r,c)] = state[(r,c)][:idx]
            if len(state[(nr,nc)]) >= 4:
                print(turn)
                exit()
        elif board[nr-1][nc-1] == 1:
            block = state[(r,c)][idx:]
            for x in block:
                info[x][0] = nr
                info[x][1] = nc
            state[(nr,nc)].extend(block[::-1])
            state[(r,c)] = state[(r,c)][:idx]
            if len(state[(nr,nc)]) >= 4:
                print(turn)
                exit()
        else:
            if check:
                return
            if d == 1:
                info[i][2] = 2
            elif d == 2:
                info[i][2] = 1
            elif d == 3:
                info[i][2] = 4
            else:
                info[i][2] = 3
            move(i,True)
    else:
        if check:
            return
        if d == 1:
            info[i][2] = 2
        elif d == 2:
            info[i][2] = 1
        elif d == 3:
            info[i][2] = 4
        else:
            info[i][2] = 3
        move(i,True)
        
n,k = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
info = defaultdict(list)
state = defaultdict(list)

for i in range(1,k+1):
    r,c,d = map(int,input().split())
    state[(r,c)] = [i]
    info[i] = [r,c,d]

turn = 0
while True:
    turn += 1 
    if turn > 1000:
        print(-1)
        break
    for i in range(1,k+1):
        move(i,False)  