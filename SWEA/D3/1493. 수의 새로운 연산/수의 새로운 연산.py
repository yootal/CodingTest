points = [(0, 0)] * 50001
board = [[0] * 400 for _ in range(400)]
x, y = 1, 1
nxt = 2
for i in range(1, 50001):
    points[i] = (x, y)
    board[x][y] = i
    y -= 1
    if y == 0:
        x = 1
        y = nxt
        nxt += 1
        continue
    x += 1
t = int(input())
for case in range(1, t + 1):
    p, q = map(int, input().split())
    after = (points[p][0] + points[q][0], points[p][1] + points[q][1])
    print(f"#{case} {board[after[0]][after[1]]}")
