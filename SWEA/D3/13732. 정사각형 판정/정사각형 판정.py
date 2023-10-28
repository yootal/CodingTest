from collections import deque


def bfs():
    vis = [[False] * n for _ in range(n)]
    flag = True
    cnt = 0
    for i in range(n):
        for j in range(n):
            if board[i][j] == '#' and not vis[i][j]:
                if flag:
                    cnt += 1
                    vis[i][j] = True
                    dq = deque()
                    dq.append((i, j))
                    while dq:
                        x, y = dq.popleft()
                        for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                            nx = x + dx
                            ny = y + dy
                            if 0 <= nx < n and 0 <= ny < n:
                                if board[nx][ny] == '#' and not vis[nx][ny]:
                                    vis[nx][ny] = True
                                    cnt += 1
                                    dq.append((nx, ny))
                    flag = False
                else:
                    return False
    check = int(cnt ** 0.5)
    if check ** 2 == cnt:
        return True
    else:
        return False


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    board = [list(input()) for _ in range(n)]
    if bfs():
        print(f'#{case} yes')
    else:
        print(f'#{case} no')
