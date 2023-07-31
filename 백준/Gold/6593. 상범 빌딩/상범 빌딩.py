import sys
input = sys.stdin.readline
from collections import deque

dy,dx,dh = [1,-1,0,0,0,0],[0,0,1,-1,0,0],[0,0,0,0,1,-1]

while True:
    floor,row,col = map(int,input().split())
    if floor == 0 and row == 0 and col == 0:
        exit()
        
    graph = [[] for _ in range(floor)]
    for f in range(floor):
        for _ in range(row):
            graph[f].append(list(input().rstrip()))
        input()

    visited = [[[0]*col for _ in range(row)] for _ in range(floor)]
    
    def bfs(h1,y1,x1,eh,ey,ex):
        visited[h1][y1][x1] = 1
        q = deque([(h1,y1,x1)])
        while q:
            h2,y2,x2 = q.popleft()
            if h2 == eh and y2 == ey and x2 == ex:
                return visited[h2][y2][x2]
            for i in range(6):
                nh = h2 + dh[i]
                ny = y2 + dy[i]
                nx = x2 + dx[i]
                if ny < 0 or ny > row-1 or nx < 0 or nx > col-1 or nh < 0 or nh > floor-1:
                    continue 
                if graph[nh][ny][nx] != '#' and visited[nh][ny][nx] == 0:
                    visited[nh][ny][nx] = visited[h2][y2][x2] + 1
                    q.append((nh,ny,nx))
        return 0
    
    start = ()
    end = ()
    for h in range(floor):
        for y in range(row):
            for x in range(col):
                if graph[h][y][x] == 'S':
                    start = (h,y,x)
                if graph[h][y][x] == 'E':
                    end = (h,y,x)
    
    ans = bfs(start[0],start[1],start[2],end[0],end[1],end[2])
    if ans == 0:
        print("Trapped!")
    else:
        print(f"Escaped in {ans-1} minute(s).")