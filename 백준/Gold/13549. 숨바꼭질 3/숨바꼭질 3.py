import sys
input = sys.stdin.readline
from collections import deque

board = [0] * 100001

dx = [-1,0,1]

n,k = map(int,input().split())

def bfs(v):
    board[v] = 1
    q = deque([v])
    while q:
        x = q.popleft()
        if x == k:
            return
        for i in range(3):
            if i == 1:
                nx = x * 2
                if nx > 100000 or nx < 0:
                    continue
                if board[nx] == 0:
                    board[nx] = board[x]
                    q.append(nx)
            else:
                nx = x + dx[i]
                if nx > 100000 or nx < 0:
                    continue 
                if board[nx] == 0:
                    board[nx] = board[x] + 1
                    q.append(nx)
bfs(n)
print(board[k]-1)
                

            