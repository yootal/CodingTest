import sys
input = sys.stdin.readline

n = int(input())
board = [[False] * n for _ in range(n)]
j_check = [False] * n
ans = 0

def n_queen(k):
    global ans
    if k == n:
        ans += 1
        return
    for j in range(n):
        if not j_check[j] and check(k,j):
            j_check[j] = True
            board[k][j] = True
            n_queen(k+1)
            j_check[j] = False
            board[k][j] = False
        
def check(x,y):
    i = x
    j = y
    while j > 0 and i > 0:
        i -= 1
        j -= 1
        if board[i][j]:
            return False
    i = x
    j = y
    while j < n - 1 and i > 0:
        i -= 1
        j += 1
        if board[i][j]:
            return False

    return True

n_queen(0)
print(ans)