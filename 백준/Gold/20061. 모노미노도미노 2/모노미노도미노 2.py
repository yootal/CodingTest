from sys import stdin
from collections import deque
input = stdin.readline

n = int(input())
green = [[0] * 4 for _ in range(6)]
blue = [[0] * 4 for _ in range(6)]
score = 0

for _ in range(n):
    t, x, y = map(int, input().split())

    # 처음에 넣는거
    if t == 1:
        row, col = 0, y
        for r1 in range(5, -1, -1):
            if not green[r1][y]:
                row = r1
            else:
                break
        green[row][col] = 1
        row, col = 0, x
        for r2 in range(5, -1, -1):
            if not blue[r2][x]:
                row = r2
            else:
                break
        blue[row][col] = 1
    elif t == 2:
        row, col = 0, y
        for r1 in range(5, -1, -1):
            if not green[r1][y] and not green[r1][y + 1]:
                row = r1
            else:
                break
        green[row][col] = 2
        green[row][col + 1] = 2
        row, col = 0, x
        for r2 in range(5, -1, -1):
            if not blue[r2][x]:
                row = r2
            else:
                break
        blue[row][col] = 2
        blue[row + 1][col] = 2
    else:
        row, col = 0, y
        for r1 in range(5, -1, -1):
            if not green[r1][y]:
                row = r1
                col = y
            else:
                break
        green[row][col] = 3
        green[row + 1][col] = 3
        row, col = 0, x
        for r2 in range(5, -1, -1):
            if not blue[r2][x] and not blue[r2][x + 1]:
                row = r2
                col = x
            else:
                break
        blue[row][col] = 3
        blue[row][col + 1] = 3

    # 초록에서 빙고 지우기
    while True:
        erase = []
        for i in range(6):
            if 0 not in green[i]:
                erase.append(i)
                green[i] = [0] * 4
                score += 1
        green2 = deque([[0] * 4 for _ in range(6)])
        w = 0
        for i in range(6):
            if i in erase:
                w += 1
            if sum(green[i]) == 0:
                continue
            row = i
            for j in range(4):
                if (j > 0 and green[i][j - 1] == 2 and green[i][j] == 2):
                    continue
                if green[i][j] == 2:
                    green2[row-w][j] = green[i][j]
                    green2[row-w][j + 1] = green[i][j + 1]
                else:
                    green2[row-w][j] = green[i][j]
        if green == green2:
            break
        green = green2

    green3 = deque(green)
    cnt = 2
    for i in (4, 5):
        if sum(green3[i]) == 0:
            cnt -= 1
    if cnt:
        for _ in range(cnt):
            green3.popleft()
        for _ in range(cnt):
            green3.append([0] * 4)
    green = green3

    # 파랑에서 빙고 지우기
    while True:
        erase = []
        for i in range(6):
            if 0 not in blue[i]:
                erase.append(i)
                blue[i] = [0] * 4
                score += 1
        blue2 = deque([[0] * 4 for _ in range(6)])
        w = 0
        for i in range(6):
            if i in erase:
                w += 1
            if sum(blue[i]) == 0:
                continue
            row = i
            for j in range(4):
                if (j > 0 and blue[i][j - 1] == 3 and blue[i][j] == 3):
                    continue
                if blue[i][j] == 3:
                    blue2[row-w][j] = blue[i][j]
                    blue2[row-w][j + 1] = blue[i][j + 1]
                else:
                    blue2[row-w][j] = blue[i][j]
        if blue == blue2:
            break
        blue = blue2

    blue3 = deque(blue)
    cnt = 2
    for i in (4, 5):
        if sum(blue3[i]) == 0:
            cnt -= 1
    if cnt:
        for _ in range(cnt):
            blue3.popleft()
        for _ in range(cnt):
            blue3.append([0] * 4)
    blue = blue3

print(score)
print((24 - sum([r.count(0) for r in green])) + (24 - sum([r.count(0) for r in blue])))
