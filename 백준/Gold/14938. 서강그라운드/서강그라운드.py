import sys
input = sys.stdin.readline

n,m,r = map(int,input().split())
item_value = [0] + list(map(int,input().split()))
graph = [[sys.maxsize] * (n+1) for _ in range(n+1)]

for _ in range(r):
    a,b,l = map(int,input().split())
    graph[a][b] = min(graph[a][b],l)
    graph[b][a] = min(graph[b][a],l)

for i in range(1,n+1):
    graph[i][i] = 0

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

ans = 0
for i in range(1,n+1):
    cnt = 0
    for j in range(1,n+1):
        if graph[i][j] <= m:
            cnt += item_value[j]
    ans = max(ans,cnt)
    
print(ans)