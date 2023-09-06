import sys
input = sys.stdin.readline
inf = sys.maxsize

v,e = map(int,input().split())
graph = [[inf] * (v+1) for _ in range(v+1)]

for _ in range(e):
    a,b,c = map(int,input().split())
    c = min(graph[a][b],c)
    graph[a][b] = c
    
for i in range(1,v+1):
    graph[i][i] = 0    
    
for k in range(1,v+1):
    for i in range(1,v+1):
        for j in range(1,v+1):
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

ans = inf
for i in range(1,v+1):
    for j in range(i+1,v+1):
        ans = min(ans, graph[i][j] + graph[j][i])
        
if ans == inf:
    print(-1)
else:
    print(ans)