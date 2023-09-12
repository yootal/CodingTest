import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

dy = [1,-1,0,0]
dx = [0,0,1,-1]

m,n,k = map(int,input().split())
vis = [[False] * n for _ in range(m)]
for _ in range(k):
    x1,y1,x2,y2 = map(int,input().split())
    for i in range(y1,y2):
        for j in range(x1,x2):
            vis[i][j] = True
            
def dfs(i,j):
    global size
    vis[i][j] = True
    size += 1
    s = []
    s.append((i,j))
    while s:
        x,y = s.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n:
                if not vis[nx][ny]:
                    vis[nx][ny] = True
                    s.append((nx,ny))  
                    size += 1
ans = 0
size_list = []
for i in range(m):
    for j in range(n):
        if not vis[i][j]:
            size = 0
            dfs(i,j)
            size_list.append(size)
            ans += 1
            
print(ans)
size_list.sort()
print(*size_list)