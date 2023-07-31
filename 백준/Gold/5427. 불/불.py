from collections import deque
import sys
input = sys.stdin.readline

dy = [1,-1,0,0]
dx = [0,0,1,-1]

for _ in range(int(input())):

    col, row = map(int,input().split())

    graph = []
    for _ in range(row):
        graph.append(list(input().rstrip()))

    visited = [[0]*col for _ in range(row)] 

    start_point = []
    fire_point = []

    def bfs(point,check):
        for p in point:
            visited[p[0]][p[1]] = 1
        q = deque(point)
        while q:
            r1,c1 = q.popleft()
            for d in range(4):
                ny = r1 + dy[d]
                nx = c1 + dx[d]
                if nx < 0 or ny < 0 or nx > col - 1 or ny > row - 1:
                    if check == 0:
                        continue
                    else:
                        return visited[r1][c1]
                if graph[ny][nx] != '#' and visited[ny][nx] == 0 or graph[ny][nx] == '.' and visited[ny][nx] > visited[r1][c1] + 1:
                    visited[ny][nx] = visited[r1][c1] + 1
                    q.append((ny,nx))
        return 0

    for r in range(row):
        for c in range(col):
            if graph[r][c] == '@':
                start_point.append((r,c))
            elif graph[r][c] == '*':
                fire_point.append((r,c))

    bfs(fire_point,0)
    ans = bfs(start_point,1)

    if ans == 0:
        print("IMPOSSIBLE")
    else:
        print(ans)    