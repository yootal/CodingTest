import sys
input = sys.stdin.readline
inf = sys.maxsize

n,m = map(int,input().split())
graph = [[inf] * (n+1) for _ in range(n+1)]

for _ in range(m):
    u,v,b = map(int,input().split())
    if b == 0:
        graph[u][v] = 0
        graph[v][u] = 1
    else:
        graph[u][v] = 0
        graph[v][u] = 0
        
for i in range(1,n+1):
    graph[i][i] = 0
        
for l in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            graph[i][j] = min(graph[i][j], graph[i][l] + graph[l][j]) 

k = int(input())
for _ in range(k):
    s,e = map(int,input().split())
    print(graph[s][e])