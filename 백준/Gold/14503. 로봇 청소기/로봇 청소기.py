import sys
input=sys.stdin.readline
from collections import deque

# 0북 1동 2남 3서
dx,dy = [-1,0,1,0],[0,1,0,-1]

n,m = map(int,input().split())
r,c,d = map(int,input().split())
state = [list(map(int,input().split())) for _ in range(n)]

count = 0
q = deque()
q.append((r,c,d))
while q:
    x,y,dir = q.popleft()
    if state[x][y] == 0:
        state[x][y] = 2
        count += 1
    zero_count = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if state[nx][ny] == 0:
            zero_count += 1
    if zero_count == 0:
        nx2 = x + dx[(dir+2) % 4]
        ny2 = y + dy[(dir+2) % 4]
        if state[nx2][ny2] != 1:
            q.append((nx2,ny2,dir))
        else:
            break
    else:
        for j in range(dir-1,dir-5,-1):
            if j < 0:
                idx = j + 4
            else:
                idx = j
            nx3 = x + dx[idx]
            ny3 = y + dy[idx]
            if state[nx3][ny3] == 0:
                q.append((nx3,ny3,idx))
                break
            
print(count)