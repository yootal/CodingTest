from sys import stdin
from collections import deque, defaultdict
input = stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]
vis = [[[0] * 2 ** 10 for _ in range(20)] for _ in range(20)]  
case = 0

def clean(x,y):
    global vis,case
    case += 1
    vis[x][y][0] = case
    dq = deque()
    dq.append((x,y,0,0))
    while dq:
        x,y,cnt,bitmask = dq.popleft()
        if bitmask == (1 << dirt_size) - 1:
            return cnt
        for dx,dy in d:
            nx = x + dx
            ny = y + dy
            if nx < 0 or nx > h-1 or ny < 0 or ny > w-1 or board[x][y] == 'x':
                continue
            if board[nx][ny] == '*':
                nxt_bitmask = bitmask | (1 << dirt_idx[(nx,ny)])
                if vis[nx][ny][nxt_bitmask] != case:
                    vis[nx][ny][nxt_bitmask] = case
                    dq.append((nx,ny,cnt+1,nxt_bitmask))
            else:
                if vis[nx][ny][bitmask] != case:
                    vis[nx][ny][bitmask] = case
                    dq.append((nx,ny,cnt+1,bitmask))  
    return -1     
                            
while True:
    w,h = map(int,input().split())
    if w == 0 and h == 0:
        break
    dirt_size = 0
    dirt_idx = defaultdict(int)
    board = []
    for i in range(h):
        inp = list(input().rstrip())
        for j in range(w):
            if inp[j] == 'o':
                inp[j] = '.'
                robot = (i,j)
            elif inp[j] == '*':
                dirt_idx[(i,j)] = dirt_size
                dirt_size += 1
        board.append(inp)
    print(clean(robot[0],robot[1]))
    