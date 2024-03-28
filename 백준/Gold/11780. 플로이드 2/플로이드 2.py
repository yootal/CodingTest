import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
inf = sys.maxsize
graph = [[inf] * (n+1) for _ in range(n+1)]
nxt = [[0] * (n+1) for _ in range(n+1)]

for _ in range(m):
    a,b,c = map(int,input().split())
    if graph[a][b] > c:
        graph[a][b] = c
    nxt[a][b] = b
    
for i in range(1,n+1):
    graph[i][i] = 0

for k in range(1,n+1): 
    for i in range(1,n+1): 
        for j in range(1,n+1): 
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]
                nxt[i][j] = nxt[i][k]

for row in graph[1:]:
    for col in row[1:]:
        print(col if col != inf else 0,end=" ")
    print()

for i in range(1,n+1):
    for j in range(1,n+1):
        if graph[i][j] in (0,inf):
            print(0)
            continue
        path = []
        st = i
        while st != j:
            path.append(st)
            st = nxt[st][j]
        path.append(j)
        print(len(path),*path)
