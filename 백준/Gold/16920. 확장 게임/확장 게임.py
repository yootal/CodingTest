import sys
input=sys.stdin.readline
from collections import deque

dx,dy = [-1,1,0,0],[0,0,-1,1]

def bfs():
    q = deque()
    for sp in start_point:
        for sp2 in sp:
            q.append(sp2)
            visited[sp2[0]][sp2[1]] = sp2[2] + 1

    q2 = deque()
    startP = 0
    while q:
        # while q[0][2] == startP % p:
        while len(q) > 0 and q[0][2] == startP % p:
            row,col,player = q.popleft()
            q2.append((row,col,0))
        while q2:
            row2,col2,cnt = q2.popleft()
            
            if cnt == move[player]:
                q.append((row2,col2,player))
                
            elif cnt < move[player]:
                for i in range(4):
                    ny = row2 + dy[i]
                    nx = col2 + dx[i]
                    if nx < 0 or nx > m-1 or ny < 0 or ny > n-1:
                        continue
                    if board[ny][nx] == '.' and visited[ny][nx] == 0:
                        visited[ny][nx] = player + 1
                        q2.append((ny,nx,cnt+1))
        startP+=1

n,m,p = map(int,input().split())
move = list(map(int,input().split()))

board = []
for _ in range(n):
    board.append(input().rstrip())
    
visited = [[0] * m for _ in range(n)]

start_point = [[] for _ in range(p)]
for i in range(n):
    for j in range(m):
        for num in range(p):
            if board[i][j] == str(num+1):
                start_point[num].append((i,j,num))   
               
bfs()

for pn in range(p):
    cnt = 0
    for v in visited:
        cnt += v.count(pn+1)
    print(cnt,end = " ")
                
     

