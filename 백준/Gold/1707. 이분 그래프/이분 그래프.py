from collections import deque
import sys
input=sys.stdin.readline

def bfs(start, group):
    q = deque([start])
    visited[start] = group 
    while q:
        v = q.popleft()
        for g in graph[v]:
            if visited[g] == 0:
                q.append(g)
                visited[g] = -1 * visited[v]
            elif visited[g] == visited[v]:
                return False
    return True                
                    
k = int(input())
for _ in range(k):
    v,e = map(int,input().split())
    graph = [[] for _ in range(v+1)]
    visited = [0] * (v+1)
    for _ in range(e):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
    for i in range(1, v+1):
        if visited[i] == 0:
            result = bfs(i,1)
            if not result:
                break
            
    print("YES" if result else "NO")