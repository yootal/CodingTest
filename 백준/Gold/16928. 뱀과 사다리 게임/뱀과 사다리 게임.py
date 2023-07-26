from collections import deque
import sys
input=sys.stdin.readline

dx = [1,2,3,4,5,6]
ladder = []
snake = []
board = [0] * 101

n,m = map(int,input().split())
for _ in range(n):
    ladder.append(list(map(int,input().split())))
for _ in range(m):
    snake.append(list(map(int,input().split())))
            
def bfs(pos):
    q = deque([pos])
    while q:
        position = q.popleft()
        for i in range(6):
            nx = position + dx[i]
            if nx > 100:
                continue
            for l in ladder:
                if nx == l[0]:
                    nx = l[1]
            for s in snake: 
                if nx == s[0]:
                    nx = s[1]
            if board[nx] == 0:
                board[nx] = board[position] + 1 
                q.append(nx)
                
bfs(1)
print(board[100])