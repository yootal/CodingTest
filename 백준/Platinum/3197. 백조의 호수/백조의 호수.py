import sys
from collections import deque
input = sys.stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]

def limit_check(i,j):
    return i < 0 or i >= n or j < 0 or j >=m

def find_swan(swan_q,lake):
    nxt_swan = deque()
    while swan_q:
        x,y = swan_q.popleft()
        
        if x == ex and y == ey:
            return True, None
        
        for dx,dy in d:
            nx = x + dx
            ny = y + dy
            if limit_check(nx,ny) or visited[nx][ny]:
                continue
            if lake[nx][ny] == 'X':
                nxt_swan.append((nx,ny))
            else:
                swan_q.append((nx,ny))
            visited[nx][ny] = True
            
    return False, nxt_swan    

def melt(water_q,lake):
    nxt_water = deque()
    while water_q:
        x,y = water_q.popleft()
        for dx,dy in d:
            nx = x + dx
            ny = y + dy
            if limit_check(nx,ny):
                continue
            if lake[nx][ny] == 'X':
                nxt_water.append((nx,ny))
                lake[nx][ny] = '.'
                
    return nxt_water

n,m = map(int,input().split())
lake = []
swan = []
swan_q = deque()
water_q = deque()

for r in range(n):
    lake_inp = list(input().rstrip())
    for c, info in enumerate(lake_inp):
        if info == '.' or info == 'L':
            water_q.append((r,c))
        if info == 'L':
            swan.append((r,c))
    lake.append(lake_inp)

day = 0
visited = [[False] * m for _ in range(n)]

sx, sy = swan[0]
ex, ey = swan[1]
swan_q.append((sx,sy))
visited[sx][sy] = True

while True:
    found, nxt_swan = find_swan(swan_q,lake)
    if found:
        break
    day += 1
    water_q = melt(water_q,lake)
    swan_q = nxt_swan

print(day)

            