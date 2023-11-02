def find_start(x, y):
    global ans
    if x == 0:
        ans = y
        return
    if y - 1 >= 0 and board[x][y - 1] == 1 and not vis[x][y - 1]:
        vis[x][y - 1] = True
        find_start(x, y - 1)
    elif y + 1 < 100 and board[x][y + 1] == 1 and not vis[x][y + 1]:
        vis[x][y + 1] = True
        find_start(x, y + 1)
    else:
        vis[x-1][y] = True
        find_start(x - 1, y)


def find_end():
    for col in range(100):
        if board[99][col] == 2:
            return col


for case in range(1, 10 + 1):
    n = int(input())
    board = [list(map(int, input().split())) for _ in range(100)]
    vis = [[False] * 100 for _ in range(100)]
    end = find_end()
    vis[99][end] = True
    ans = -1
    find_start(99, end)
    print(f'#{n} {ans}')