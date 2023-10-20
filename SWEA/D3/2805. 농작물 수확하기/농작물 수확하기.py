from collections import deque

t = int(input())
for case in range(1,t+1):
    n = int(input())
    farm = [[int(x) for x in list(input().rstrip())] for _ in range(n)]
    dist = [[-1] * n for _ in range(n)]
    
    limit = n//2
    ans = farm[n//2][n//2]
    
    dq = deque()
    dq.append((n//2,n//2))
    dist[n//2][n//2] = 0
    while dq:
        x,y = dq.popleft()
        for dx,dy in [(-1,0),(1,0),(0,-1),(0,1)]:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n:
                if dist[nx][ny] == -1:
                    dist[nx][ny] = dist[x][y] + 1
                    ans += farm[nx][ny]
                    if dist[nx][ny] < limit:
                        dq.append((nx,ny))
                        
    print(f"#{case} {ans}")