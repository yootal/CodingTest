import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [[sys.maxsize] * (n+1) for _ in range(n+1)]

for _ in range(m):
    s,e,t = map(int,input().split())
    graph[s][e] = min(graph[s][e],t)

c = int(input())
city = list(map(int,input().split()))

for i in range(1,n+1):
    graph[i][i] = 0

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

ans = [0]    
min_time = sys.maxsize
for i in range(1,n+1):
    max_time = 0
    for j in city:
        if j != i and graph[i][j] != sys.maxsize and graph[j][i] != sys.maxsize:
            if max_time < graph[i][j] + graph[j][i]:
                max_time = graph[i][j] + graph[j][i]
    ans.append(max_time)
    
min_time = min(ans[1:])
for a in range(1,n+1):
    if ans[a] == min_time:
        print(a, end = " ")