from collections import deque


def bfs(st):
    vis[st[0]][st[1]] = True
    dq = deque()
    dq.append((st[0], st[1]))
    while dq:
        x, y = dq.popleft()
        if board[x][y] == 3:
            return True
        for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < 100 and 0 <= ny < 100:
                if not vis[nx][ny] and board[nx][ny] != 1:
                    vis[nx][ny] = True
                    dq.append((nx, ny))
    return False


def find_start():
    for i in range(100):
        for j in range(100):
            if board[i][j] == 2:
                return (i, j)


for case in range(1, 10 + 1):
    n = int(input())
    board = [list(map(int, input().rstrip())) for _ in range(100)]
    vis = [[False] * 100 for _ in range(100)]
    st = find_start()
    if bfs(st):
        print(f'#{n} 1')
    else:
        print(f'#{n} 0')