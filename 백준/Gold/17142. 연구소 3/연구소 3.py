from sys import stdin, maxsize
from itertools import combinations
from copy import deepcopy
from collections import deque
input = stdin.readline

n,m = map(int,input().split())
board = []
virus = []
virus_cnt = 0
wall_cnt = 0

for i in range(n):
    inp = list(map(int,input().split()))
    for j in range(n):
        if inp[j] == 2:
            inp[j] = -2
            virus.append((i,j))
            virus_cnt += 1
        elif inp[j] == 1:
            wall_cnt += 1 
    board.append(inp)

finish_cnt = n * n - wall_cnt - virus_cnt
ans = maxsize
for comb in combinations(range(len(virus)),m):
    board2 = deepcopy(board)
    dq = deque()
    infect_cnt = 0
    for idx in comb:
        x,y = virus[idx]
        board2[x][y] = 1
        dq.append((virus[idx]))
    while dq:
        x,y = dq.popleft()
        if infect_cnt == finish_cnt:
            continue
        for dx,dy in ((-1,0),(1,0),(0,-1),(0,1)):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n:
                if board2[nx][ny] == 0:
                    infect_cnt += 1
                    board2[nx][ny] = board2[x][y] + 1
                    dq.append((nx,ny))
                elif board2[nx][ny] == -2:
                    board2[nx][ny] = board2[x][y] + 1
                    dq.append((nx,ny))

    if infect_cnt == finish_cnt:
        ans = min(ans,board2[x][y]-1)
        
print(ans if ans != maxsize else -1)
