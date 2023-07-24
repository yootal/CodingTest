from collections import deque
import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline

n,m,r = map(int,input().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
count = 1

for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(v):
    global count
    
    q = deque([r])
    visited[r] = 1
    while q:
        v = q.popleft()
        graph[v].sort(reverse=True)
        for g in graph[v]:
            if visited[g] == 0:
                count += 1
                visited[g] = count
                q.append(g)
bfs(r)

for i in range(1,n+1):
    print(visited[i])
    

