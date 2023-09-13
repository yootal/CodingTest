import sys
input=sys.stdin.readline
from collections import deque, defaultdict

dx,dy = [-1,1,0,0],[0,0,-1,1]

def bfs():
    while True:
        check = False
        for pi in range(1,p+1):
            q = deque(start_point[pi])
            nextq = []
            while q:
                row,col,step = q.popleft()
                if step >= move[pi-1]:
                    nextq.append((row,col,0))
                    continue
                for i in range(4):
                    ny = row + dy[i]
                    nx = col + dx[i]
                    if nx < 0 or nx > m-1 or ny < 0 or ny > n-1:
                        continue
                    if board[ny][nx] == '.' and not visited[ny][nx]:
                        q.append((ny,nx,step+1))
                        visited[ny][nx] = True
                        player_cnt[pi-1] += 1
                        check = True
            start_point[pi] = nextq
            
        if not check:
            break

n,m,p = map(int,input().split())
move = list(map(int,input().split()))
board = [input().rstrip() for _ in range(n)]
visited = [[False] * m for _ in range(n)]
player_cnt = [0] * p
start_point = defaultdict(list)

for i in range(n):
    for j in range(m):
        if board[i][j].isdigit():
            player_cnt[int(board[i][j])-1] += 1
            start_point[int(board[i][j])].append((i,j,0))   
               
bfs()
print(*player_cnt)