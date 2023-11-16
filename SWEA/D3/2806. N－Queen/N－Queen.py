def check(r, c):
    if diagonal1[r + c]:
        return False
    if diagonal2[r - c + n - 1]:
        return False
    if column[c]:
        return False
    return True


def n_queen(r):
    global ans
    if r == n:
        ans += 1
        return
    for c in range(n):
        if check(r, c):
            diagonal1[r + c] = True
            diagonal2[r - c + n - 1] = True
            column[c] = True
            n_queen(r + 1)
            diagonal1[r + c] = False
            diagonal2[r - c + n - 1] = False
            column[c] = False


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    diagonal1 = [False] * (2 * n - 1)
    diagonal2 = [False] * (2 * n - 1)
    column = [False] * n
    ans = 0
    n_queen(0)
    print(f'#{case} {ans}')
