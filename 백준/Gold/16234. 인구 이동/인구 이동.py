from sys import stdin
from collections import deque
input = stdin.readline

def bfs(i, j):
    vis[i][j] = True
    group = set()
    dq = deque([(i, j)])
    while dq:
        x, y = dq.popleft()
        for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n:
                if not vis[nx][ny] and (l <= abs(p[x][y] - p[nx][ny]) <= r):
                    vis[nx][ny] = True
                    if not group:
                        group.add((x, y))
                        group.add((nx, ny))
                    else:
                        group.add((nx, ny))
                    dq.append((nx, ny))
    return group

n, l, r = map(int, input().split())
p = [list(map(int, input().split())) for _ in range(n)]

ans = 0
while True:
    vis = [[False] * n for _ in range(n)]
    move = []
    for i in range(n):
        for j in range(n):
            if not vis[i][j]:
                g = bfs(i, j)
                if g:
                    move.append(g)
    if not move:
        break
    else:
        for g in move:
            total = 0
            for x, y in g:
                total += p[x][y]
            v = total // len(g)
            for x, y in g:
                p[x][y] = v
        ans += 1
print(ans)