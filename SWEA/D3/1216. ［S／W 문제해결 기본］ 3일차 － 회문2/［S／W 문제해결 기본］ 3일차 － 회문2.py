def palindrome(m, arr):
    for i in range(100):
        for j in range(0, 100 - m + 1):
            if arr[i][j] == arr[i][j + m - 1]:
                for k in range(1, m // 2):
                    if arr[i][j + k] != arr[i][j + m - 1 - k]:
                        break
                else:
                    return True
        for j in range(0, 100 - m + 1):
            if arr[j][i] == arr[j + m - 1][i]:
                for k in range(1, m // 2):
                    if arr[j + k][i] != arr[j + m - 1 - k][i]:
                        break
                else:
                    return True
    return False


for case in range(1, 11):
    N = int(input())
    board = [list(input()) for _ in range(100)]
    for ans in range(100, -1, -1):
        if palindrome(ans, board):
            print(f'#{case} {ans}')
            break