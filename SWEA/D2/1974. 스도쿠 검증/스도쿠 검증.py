def sudoku():
    for i in range(9):
        vis1 = [False] * 9
        vis2 = [False] * 9
        for j in range(9):
            if vis1[board[i][j] - 1]:
                return False
            vis1[board[i][j] - 1] = True

        for j in range(9):
            if vis2[board[j][i] - 1]:
                return False
            vis2[board[j][i] - 1] = True

    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            vis3 = [False] * 9
            for k in range(3):
                for l in range(3):
                    if vis3[board[i + k][j + l] - 1]:
                        return False
                    vis3[board[i + k][j + l] - 1] = True
    return True


t = int(input())
for case in range(1, t + 1):
    board = [list(map(int, input().split())) for _ in range(9)]
    if sudoku():
        print(f'#{case} 1')
    else:
        print(f'#{case} 0')
