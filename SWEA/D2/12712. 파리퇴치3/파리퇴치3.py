from collections import deque

d1 = ((-1,-1),(-1,1),(1,-1),(1,1))
d2 = ((-1,0),(0,-1),(1,0),(0,1))

def cnt(x,y):
    sum1,sum2 = board[x][y],board[x][y]
    
    dq = deque()
    for i in range(4):
        dq.append((x,y,0,d1[i]))
    while dq:
        px,py,depth,dir = dq.popleft() 
        if depth == m-1:
            continue
        nx = px + dir[0]
        ny = py + dir[1]
        if 0 <= nx < n and 0 <= ny < n:
            sum1 += board[nx][ny]
            dq.append((nx,ny,depth+1,dir))
    
    dq.clear()
    for i in range(4):
        dq.append((x,y,0,d2[i]))
    while dq:
        px,py,depth,dir = dq.popleft() 
        if depth == m-1:
            continue
        nx = px + dir[0]
        ny = py + dir[1]
        if 0 <= nx < n and 0 <= ny < n:
            sum2 += board[nx][ny]
            dq.append((nx,ny,depth+1,dir))
    return max(sum1,sum2)
    
t = int(input())
for case in range(1, t + 1):
    n,m = map(int,input().split())
    board = [list(map(int,input().split())) for _ in range(n)]
    ans = 0
    for i in range(n):
        for j in range(n):
            ans = max(ans,cnt(i,j))            
    print(f'#{case} {ans}')    