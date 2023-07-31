import sys
input = sys.stdin.readline
from collections import deque

F, S, G, U, D = map(int,input().split())

dy = [U,-D]
visited = [0] * F

def bfs(f):
    visited[f] = 1
    q = deque([f])
    while q:
        floor = q.popleft()
        if floor == G-1:
            return visited[floor]
        for i in range(2):
            ny = floor + dy[i]
            if ny < 0 or ny > F-1:
                continue 
            if visited[ny] == 0:
                visited[ny] = visited[floor] + 1
                q.append(ny)
    return 0

ans = bfs(S-1)
if ans == 0:
    print("use the stairs")
else:
    print(ans-1)