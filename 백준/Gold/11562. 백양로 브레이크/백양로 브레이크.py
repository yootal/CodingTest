from sys import maxsize, stdin
input = stdin.readline

def floyd():
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]

n,m = map(int,input().split())
graph = [[maxsize] * (n+1) for _ in range(n+1)]
for _ in range(m):
    a,b,c = map(int,input().split())
    if c == 0:
        graph[a][b] = 0
        graph[b][a] = 1
    elif c == 1:
        graph[a][b] = 0
        graph[b][a] = 0

for i in range(1,n+1):
    graph[i][i] = 0
                
floyd()

k = int(input())
for _ in range(k):
    s,e = map(int,input().split())
    print(graph[s][e])