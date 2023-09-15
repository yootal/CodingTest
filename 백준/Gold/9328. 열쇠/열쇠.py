import sys
from collections import deque, defaultdict
input = sys.stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]

def bfs(start_point):
    doc = 0 # 문서 (답)
    door = defaultdict(list) # 문 좌표 기록
    
    q = deque()
    vis = [[False] * m for _ in range(n)]
    
    for sx,sy in start_point:
        if board[sx][sy] == '.':
            vis[sx][sy] = True
            q.append((sx,sy))
        elif board[sx][sy].isupper():
            if key_check[board[sx][sy].lower()]:
                vis[sx][sy] = True
                q.append((sx,sy))
            else:
                door[board[sx][sy]].append((sx,sy))
        elif board[sx][sy].islower():
            key_check[board[sx][sy]] = True
            vis[sx][sy] = True
            q.append((sx,sy))
            for dx,dy in door[board[sx][sy].upper()]:
                vis[dx][dy] = True
                q.append((dx,dy))
        elif board[sx][sy] == '$':
            doc += 1
            vis[sx][sy] = True
            q.append((sx,sy))
            
    while q:
        x,y = q.popleft()
        for x1,y1 in d:
            nx = x + x1
            ny = y + y1
            
            if 0 > nx or nx > n - 1 or 0 > ny or ny > m - 1:
                continue
            if board[nx][ny] == '*':
                continue
            
            # 이동 가능한 곳
            if board[nx][ny] == '.' and not vis[nx][ny]:
                vis[nx][ny] = True
                q.append((nx,ny))
                
            # 대문자 (문)
            elif board[nx][ny].isupper():
                if key_check[board[nx][ny].lower()]:
                    if not vis[nx][ny]:
                        vis[nx][ny] = True
                        q.append((nx,ny))
                else:
                    door[board[nx][ny]].append((nx,ny))
                    
            # 소문자 (열쇠)
            elif board[nx][ny].islower() and not vis[nx][ny]:
                key_check[board[nx][ny]] = True
                vis[nx][ny] = True
                q.append((nx,ny))
                for dx,dy in door[board[nx][ny].upper()]:
                    vis[dx][dy] = True
                    q.append((dx,dy))
                    
            # 문서
            elif board[nx][ny] == '$' and not vis[nx][ny]:
                doc += 1
                vis[nx][ny] = True
                q.append((nx,ny))        
                 
    return doc
    
for _ in range(int(input())):
    n,m = map(int,input().split())
    board = [input().rstrip() for _ in range(n)]
    key = input().rstrip()
    key_check = defaultdict(bool) # 열쇠 체크
    
    if key != '0':        
        key = list(key)
        for k in key:
            key_check[k] = True
    
    start_point = [] # 시작 지점
    for i in range(1,n-1):
        if board[i][0] != '*':
            start_point.append((i,0))
        if board[i][m-1] != '*':
            start_point.append((i,m-1))
    for j in range(m):
        if board[0][j] != '*':
            start_point.append((0,j))
        if board[n-1][j] != '*':
            start_point.append((n-1,j))
    
    print(bfs(start_point))
            