from sys import stdin
from collections import deque
input = stdin.readline

def find_near(i, j):
    vis = [[-1] * n for _ in range(n)]
    vis[i][j] = 0
    dq = deque([(i, j)])
    eat_possible = []
    while dq:
        x, y = dq.popleft()
        if 0 < area[x][y] < shark_size:
            eat_possible.append((vis[x][y], x, y))
            continue
        for dx, dy in ((-1, 0), (0, -1), (1, 0), (0, 1)):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n:
                if vis[nx][ny] == -1 and area[nx][ny] <= shark_size:
                    vis[nx][ny] = vis[x][y] + 1
                    dq.append((nx, ny))
    if eat_possible:
        return sorted(eat_possible)[0]
    else:
        return 0

shark_size = 2
eat_count = 0
n = int(input())
area = []
for i in range(n):
    inp = list(map(int, input().split()))
    for j in range(n):
        if inp[j] == 9:
            shark_pos = (i, j)
            inp[j] = 0
    area.append(inp)

ans = 0
while True:
    result = find_near(shark_pos[0], shark_pos[1])
    if not result:
        break
    eat_count += 1
    if eat_count == shark_size:
        shark_size += 1
        eat_count = 0
    ans += result[0]
    shark_pos = (result[1], result[2])
    area[shark_pos[0]][shark_pos[1]] = 0
print(ans)