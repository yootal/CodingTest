def solve():
    check = [False] * 8
    rook = 0
    for i in range(8):
        cnt = 0
        for j in range(8):
            if board[i][j] == 'O':
                if cnt == 1:
                    return False
                if not check[j]:
                    check[j] = True
                    cnt += 1
                    rook += 1
                else:
                    return False
    if rook == 8:
        return True
    else:
        return False


t = int(input())
for case in range(1, t + 1):
    board = [list(input()) for _ in range(8)]
    if solve():
        print(f'#{case} yes')
    else:
        print(f'#{case} no')