def find_shortest(x, y, st):
    global min_dist, ans
    if x == 99:
        if min_dist >= vis[x][y]:
            min_dist = vis[x][y]
            ans = st
        return
    if y - 1 >= 0 and board[x][y - 1] == 1 and not vis[x][y - 1]:
        vis[x][y - 1] = vis[x][y] + 1
        find_shortest(x, y - 1, st)
    elif y + 1 < 100 and board[x][y + 1] == 1 and not vis[x][y + 1]:
        vis[x][y + 1] = vis[x][y] + 1
        find_shortest(x, y + 1, st)
    else:
        vis[x + 1][y] = vis[x][y] + 1
        find_shortest(x + 1, y, st)


def find_start():
    points = []
    for col in range(100):
        if board[0][col] == 1:
            points.append(col)
    return points


for case in range(1, 10 + 1):
    n = int(input())
    board = [list(map(int, input().split())) for _ in range(100)]
    start_points = find_start()
    min_dist = 1e9
    ans = -1
    for col in start_points:
        vis = [[0] * 100 for _ in range(100)]
        vis[0][col] = 1
        find_shortest(0, col, col)
    print(f'#{n} {ans}')
