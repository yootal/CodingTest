import sys
from itertools import combinations
from collections import deque
input = sys.stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]
n,m,g,r = map(int,input().split())
garden = []
start_point = []
for i in range(n):
    info = list(map(int,input().split()))
    for j,s in enumerate(info):
        if s == 2:
            start_point.append((i,j))
    garden.append(info)
    
def count_flower(green,red):
    global ans
    q = deque()
    state = [[[0,0] for _ in range(m)] for _ in range(n)]
    
    for gx,gy in green:
        state[gx][gy] = [0,1]
        q.append((gx,gy))
    for rx,ry in red:
        state[rx][ry] = [0,2]
        q.append((rx,ry))    

    cnt = 0
    while q:
        x,y = q.popleft()
        
        time = state[x][y][0]
        color = state[x][y][1]
        
        if color == 3:
            continue
        
        for dx,dy in d:
            nx = x + dx
            ny = y + dy
            if nx < 0 or nx >= n or ny < 0 or ny >= m or garden[nx][ny] == 0:
                continue
            if state[nx][ny][1] == 0:
                state[nx][ny] = [time + 1, color]
                q.append((nx,ny))
            elif state[nx][ny][1] == 1:
                if color == 2 and state[nx][ny][0] == time + 1:
                    cnt += 1
                    state[nx][ny][1] = 3 
            elif state[nx][ny][1] == 2:
                if color == 1 and state[nx][ny][0] == time + 1:
                    cnt += 1
                    state[nx][ny][1] = 3
                    
    ans = max(ans,cnt)
    
ans = 0
for green in combinations(start_point,g):
    remaining = [sp for sp in start_point if sp not in green]
    for red in combinations(remaining,r):
        count_flower(green,red)
        
print(ans)
