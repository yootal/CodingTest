import sys
inf = sys.maxsize
input = sys.stdin.readline

def floyd():
    for k in range(1,v+1):
        for i in range(1,v+1):
            for j in range(1,v+1):
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]

v,e = map(int,input().split())
graph = [[inf] * (v+1) for _ in range(v+1)]
for _ in range(e):
    a,b,c = map(int,input().split())
    graph[a][b] = c

for i in range(1,v+1):
    graph[i][i] = 0
                
floyd()
min_cycle = inf
for i in range(1,v+1):
    for j in range(1,v+1):
        if i == j:
            continue
        if min_cycle > graph[i][j] + graph[j][i]:
            min_cycle = graph[i][j] + graph[j][i]

print(min_cycle if min_cycle != inf else -1)