def sudoku():
    s = set()
    for i in range(9):
        for j in range(9):
            if board[i][j] in s:
                return False
            s.add(board[i][j])
        s.clear()
        for j in range(9):
            if board[j][i] in s:
                return False
            s.add(board[j][i])
        s.clear()
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            for k in range(3):
                for l in range(3):
                    if board[i + k][j + l] in s:
                        return False
                    s.add(board[i + k][j + l])
            s.clear()
    return True


t = int(input())
for case in range(1, t + 1):
    board = [list(map(int, input().split())) for _ in range(9)]
    if sudoku():
        print(f'#{case} 1')
    else:
        print(f'#{case} 0')
