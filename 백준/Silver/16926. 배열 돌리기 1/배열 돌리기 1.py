from sys import stdin
from collections import deque
input = stdin.readline

n,m,r = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
ans = [[0] * m for _ in range(n)]
dq = deque()

loop = min(n,m) // 2
for i in range(loop):
    dq.clear()
    dq.extend(board[i][i:m-i])
    dq.extend([row[m-i-1] for row in board[i+1:n-i-1]])
    dq.extend(board[n-i-1][i:m-i][::-1])
    dq.extend([row[i] for row in board[i+1:n-i-1]][::-1])
    dq.rotate(-r)
    
    for j in range(i,m-i):
        ans[i][j] = dq.popleft()
    for j in range(i+1,n-i-1):
        ans[j][m-i-1] = dq.popleft()
    for j in range(m-i-1,i-1,-1):
        ans[n-i-1][j] = dq.popleft()
    for j in range(n-i-2,i,-1):
        ans[j][i] = dq.popleft()

for a in ans: 
    print(*a)
        