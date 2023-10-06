from sys import stdin, maxsize
from collections import defaultdict
input = stdin.readline

def floyd():
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]

n,m = map(int,input().split())
graph = [[maxsize] * (n+1) for _ in range(n+1)]

for i in range(1,n+1):
    graph[i][i] = 0

edges = defaultdict(tuple)
for i in range(m):
    a,b,c = map(int,input().split())
    graph[a][b] = min(graph[a][b],c)
    graph[b][a] = min(graph[b][a],c)
    edges[i] = (a,b,c)
    
floyd()

ans = maxsize
for i in range(1,n+1):
    total = 0
    for j in range(m):
        a,b,c = edges[j]
        total = max(total,(c + graph[i][a] + graph[i][b]) / 2)
    ans = min(ans,total)
    
print(f"{ans:.1f}")