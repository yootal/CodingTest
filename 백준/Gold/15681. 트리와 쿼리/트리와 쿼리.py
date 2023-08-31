import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(cur):
    vis[cur] += 1
    for nxt in graph[cur]:
        if vis[nxt] == 0:
            vis[cur] += dfs(nxt)
    return vis[cur]

n,r,q = map(int,input().split())
graph = [[] for _ in range(n+1)]
vis = [0] * (n+1)

for _ in range(n-1):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
     
dfs(r)
    
for _ in range(q):
    u = int(input())
    print(vis[u])