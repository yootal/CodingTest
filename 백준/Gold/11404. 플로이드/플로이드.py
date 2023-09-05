import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
graph = [[sys.maxsize] * (n) for _ in range(n)]

for _ in range(m):
    s,e,c = map(int,input().split())
    graph[s-1][e-1] = min(graph[s-1][e-1],c)

for i in range(n):
    graph[i][i] = 0

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
            
for i in range(n):
    for j in range(n):
        if graph[i][j] == sys.maxsize:
            print(0,end = " ")
        else:
            print(graph[i][j],end = " ")
    print()