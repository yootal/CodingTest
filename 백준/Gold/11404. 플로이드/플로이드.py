import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
inf = sys.maxsize
graph = [[inf] * (n+1) for _ in range(n+1)]

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a][b] = min(graph[a][b],c)
    
for i in range(1,n+1):
    graph[i][i] = 0

for k in range(1,n+1): 
    for i in range(1,n+1): 
        for j in range(1,n+1): 
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

for row in graph[1:]:
    for col in row[1:]:
        print(col if col != inf else 0,end=" ")
    print()