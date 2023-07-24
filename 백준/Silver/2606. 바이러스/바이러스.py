from collections import deque
import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline

n=int(input())
m=int(input())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
count=0

for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(v):
    global count   
    q = deque([v])
    visited[v] = 1
    while q:
        v = q.popleft()
        for g in graph[v]:
            if visited[g] == 0:
                count += 1
                visited[g] = 1
                q.append(g)
bfs(1)
print(count)
    

