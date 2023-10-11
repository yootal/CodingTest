from sys import stdin
input = stdin.readline

n,m = map(int,input().split())
board = [list(int(x) for x in input().rstrip()) for _ in range(n)]

limit = min(n,m)

if limit == 1:
    print(1)
else:
    ans = 0
    for k in range(1,limit+1):
        for i in range(n):
            if i + k - 1 >= n:
                break
            for j in range(m):
                if j + k - 1 >= m:
                    break 
                if board[i][j] == board[i][j+k-1] == board[i+k-1][j] == board[i+k-1][j+k-1]:
                    ans = max(ans,k)
    print(ans**2)