from sys import stdin, maxsize
from itertools import combinations
from copy import deepcopy
from collections import deque
input = stdin.readline

n,m = map(int,input().split())
board = []
virus = []
wall_cnt = 0
for i in range(n):
    inp = list(map(int,input().split()))
    for j in range(n):
        if inp[j] == 2:
            virus.append((i,j))
            inp[j] = 0
        elif inp[j] == 1:
            wall_cnt += 1 
    board.append(inp)

ans = maxsize
for comb in combinations(range(len(virus)),m):
    board2 = deepcopy(board)
    dq = deque()
    virus_cnt = m
    for idx in comb:
        x,y = virus[idx]
        board2[x][y] = 1
        dq.append(virus[idx])
    while dq:
        x,y = dq.popleft()
        for dx,dy in ((-1,0),(1,0),(0,-1),(0,1)):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n:
                if board2[nx][ny] == 0:
                    virus_cnt += 1
                    board2[nx][ny] = board2[x][y] + 1
                    dq.append((nx,ny))
    if virus_cnt == n * n - wall_cnt:
        ans = min(ans,board2[x][y] - 1)
        
print(ans if ans != maxsize else -1)