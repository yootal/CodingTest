import sys
from itertools import combinations
from collections import deque
input = sys.stdin.readline

location = {5 * i + j: (i, j) for i in range(5) for j in range(5)}
d = [(-1,0),(1,0),(0,-1),(0,1)]

def check(case):
    vis = set(case[1:])
    q = deque([case[0]])
    while q:
        x,y = q.popleft()
        for dx,dy in d:
            nx = x + dx
            ny = y + dy
            if nx < 0 or nx >= 5 or ny < 0 or ny >= 5:
                continue
            if (nx,ny) in vis:
                vis.remove((nx,ny))
                q.append((nx,ny))
    if vis:
        return False
    return True

board = []
for _ in range(5):
    board += list(input().rstrip())
    
ans = 0
for points in combinations(range(25),7):
    count = sum(map(lambda x: 1 if board[x] == 'S' else 0, points))
    if count >= 4 and check(list(map(lambda x: location[x], points))):
        ans += 1
    
print(ans)