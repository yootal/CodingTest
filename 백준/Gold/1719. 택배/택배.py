import sys
input = sys.stdin.readline
inf = sys.maxsize

n,m = map(int,input().split())
graph = [[inf] * (n+1) for _ in range(n+1)]
nxt = [[0] * (n+1) for _ in range(n+1)]

for _ in range(m):
    u,v,c = map(int,input().split())
    graph[u][v] = min(graph[u][v],c)
    graph[v][u] = min(graph[v][u],c)
    nxt[u][v] = v
    nxt[v][u] = u
    
for i in range(1,n+1):
    graph[i][i] = 0
    nxt[i][i] = 0

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]
                nxt[i][j] = nxt[i][k]
            
for i in range(1,n+1):
    for j in range(1,n+1):
        if nxt[i][j] == 0:
            print("-", end = " ")
        else:
            print(nxt[i][j], end = " ")
    print()
