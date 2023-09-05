import sys
input = sys.stdin.readline

def path(i,j):
    if nxt[i][j] == 0:
        return []
    m = nxt[i][j]
    return path(i,m) + [m] + path(m,j)

n = int(input())
m = int(input())
graph = [[sys.maxsize] * (n+1) for _ in range(n+1)]
nxt = [[0] * (n+1) for _ in range(n+1)]

for _ in range(m):
    s,e,c = map(int,input().split())
    graph[s][e] = min(graph[s][e],c)

for i in range(1,n+1):
    graph[i][i] = 0

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]
                nxt[i][j] = k
            
for i in range(1,n+1):
    for j in range(1,n+1):
        print(graph[i][j] if graph[i][j] != sys.maxsize else 0, end = " ")
    print()
    
for i in range(1,n+1):
    for j in range(1,n+1):
        if graph[i][j] in [0,sys.maxsize]:
            print(0)
            continue
        ans = [i] + path(i,j) + [j]
        print(len(ans), end = " ")
        print(*ans)