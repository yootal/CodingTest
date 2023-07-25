from collections import deque
import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline

dy = [-2,-1,2,1,2,1,-2,-1]
dx = [-1,-2,-1,-2,1,2,1,2]

def bfs(i,j):
    q = deque([(i,j)])
    visited[i][j] = 1
    while q:
        row,col = q.popleft()
        for i in range(8):
            ny = row + dy[i]
            nx = col + dx[i]
            if ny < 0 or nx < 0 or ny > l-1 or nx > l-1:
                continue
            if visited[ny][nx] == 0:
                visited[ny][nx] = visited[row][col] + 1 
                q.append((ny,nx))

t = int(input())
for _ in range(t):
    l = int(input())
    stx,sty = map(int,input().split())
    edx,edy = map(int,input().split())
    visited = [[0]*l for _ in range(l)]
    bfs(sty,stx)
    print(visited[edy][edx]-1)