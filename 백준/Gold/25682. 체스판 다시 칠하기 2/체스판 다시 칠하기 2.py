import sys
input=sys.stdin.readline

n,m,k = map(int,input().split())
board = [list(input().rstrip()) for _ in range(n)]
check = [[0] * (m+1) for _ in range(n+1)]

for row in range(1,n+1):
    for col in range(1,m+1):
        if (row+col) % 2 == 0:
            if board[row-1][col-1] == "B":
                check[row][col] = check[row-1][col] + check[row][col-1] - check[row-1][col-1]
            else:
                check[row][col] = check[row-1][col] + check[row][col-1] - check[row-1][col-1] + 1
        else:
            if board[row-1][col-1] == "W":
                check[row][col] = check[row-1][col] + check[row][col-1] - check[row-1][col-1]
            else:
                check[row][col] = check[row-1][col] + check[row][col-1] - check[row-1][col-1] + 1 
                
max_ = -float('inf')
min_ = float('inf')
for row in range(k, n+1):
    for col in range(k, m+1):
        max_ = max(check[row][col] - check[row-k][col] - check[row][col-k] + check[row-k][col-k], max_)
        min_ = min(check[row][col] - check[row-k][col] - check[row][col-k] + check[row-k][col-k], min_)
 
print(min(min_, max_, k*k - min_, k*k - max_))     

