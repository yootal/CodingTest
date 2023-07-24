from collections import deque
import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline

n,m,r=map(int,input().split())

graph = [[] for _ in range(n+1)]
visited1 = [0] * (n+1)
visited2 = [0] * (n+1)
vi1 = []
vi2 = []

for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
    
def dfs(v):
    visited1[v] = 1
    vi1.append(v)
    graph[v].sort()
    for g in graph[v]:
        if visited1[g] == 0:
            dfs(g)

def bfs(v):
    q = deque([v])
    visited2[v] = 1
    vi2.append(v)
    while q:
        v = q.popleft()
        for g in graph[v]:
            if visited2[g] == 0:
                visited2[g] = 1
                vi2.append(g)
                q.append(g)
dfs(r)
bfs(r)
for v1 in vi1:
    print(v1,end=" ")
print("")
for v2 in vi2:
    print(v2,end=" ")
    

