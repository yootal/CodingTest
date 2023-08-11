import sys
input = sys.stdin.readline
from collections import deque
import copy

dx,dy =[-1,1,0,0],[0,0,-1,1]

def count_safe_area(wall):
    global max_count
    newboard = copy.deepcopy(board)
    for wx,wy in wall:
        newboard[wx][wy] = 1
    
    q = deque()
    for vx,vy in virus_area:
        q.append((vx,vy))
    
    while q:
        vx,vy = q.popleft()
        for i in range(4):
            nvx = vx + dx[i]
            nvy = vy + dy[i]
            if 0 <= nvx < N and 0 <= nvy < M:
                if newboard[nvx][nvy] == 0:
                    newboard[nvx][nvy] = 2
                    q.append((nvx,nvy))
    
    safe_count = 0
    for nb in newboard:
        safe_count += nb.count(0)
    max_count = max(max_count,safe_count)
    return

def build_wall(wall):
    if len(wall) == 3:
        count_safe_area(wall)
        return
    for s in safe_area:
        if s not in wall:
            if len(wall) > 0 and s[0] > wall[-1][0]:
                wall.append(s)
                build_wall(wall)
                wall.pop()
            elif len(wall) > 0 and s[0] == wall[-1][0] and s[1] > wall[-1][1]:
                wall.append(s)
                build_wall(wall)
                wall.pop()
            elif len(wall) == 0:
                wall.append(s)
                build_wall(wall)
                wall.pop()

N,M = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(N)]

safe_area = []
virus_area = []
for i in range(N):
    for j in range(M):
        if board[i][j] == 0:
            safe_area.append((i,j))
        elif board[i][j] == 2:
            virus_area.append((i,j))

max_count = 0
build_wall([])
print(max_count)
