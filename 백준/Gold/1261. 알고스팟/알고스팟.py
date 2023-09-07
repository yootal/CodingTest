import sys
from heapq import heappush, heappop
input = sys.stdin.readline
inf = sys.maxsize

move = [(1,0),(-1,0),(0,1),(0,-1)]
m,n = map(int,input().split())
graph = [[[] for _ in range(m+1)] for _ in range(n+1)]
board = [[int(num) for num in input().rstrip()] for _ in range(n)]

for i in range(n):
    for j in range(m):
        for dx,dy in move:
            nx = i+1 + dx
            ny = j+1 + dy
            if nx < 1 or ny < 1 or nx > n or ny > m:
                continue
            if board[nx-1][ny-1] == 0:
                graph[i+1][j+1].append((0,nx,ny))
            elif board[nx-1][ny-1] == 1:
                graph[i+1][j+1].append((1,nx,ny))
                
def calc_dist():
    sdt = [[inf] * (m+1) for _ in range(n+1)]
    sdt[1][1] = 0
    q = []
    heappush(q,(sdt[1][1],1,1)) # 거리, 시작점
    while q:
        dis,row,col = heappop(q)
        if sdt[row][col] != dis:
            continue
        for wall,row2,col2 in graph[row][col]:
            if sdt[row2][col2] <= sdt[row][col] + wall:
                continue
            sdt[row2][col2] = sdt[row][col] + wall
            heappush(q,(sdt[row2][col2],row2,col2))
    return sdt[n][m]

print(calc_dist())
