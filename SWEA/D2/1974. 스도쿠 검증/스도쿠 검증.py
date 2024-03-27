def check():
    for i in range(9):
        row_check = set()
        col_check = set()
        for j in range(9):
            if board[i][j] in row_check:
                return 0
            else:
                row_check.add(board[i][j])
            if board[j][i] in col_check:
                return 0
            else:
                col_check.add(board[j][i])
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            part_check = set()
            for i2 in range(3):
                for j2 in range(3):
                    if board[i + i2][j + j2] in part_check:
                        return 0
                    else:
                        part_check.add(board[i + i2][j + j2])
    return 1


for case in range(1, int(input()) + 1):
    board = [list(map(int, input().split())) for _ in range(9)]
    print(f'#{case} {check()}')
