import sys
input=sys.stdin.readline
from collections import defaultdict, deque

n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
    
def bfs(s,e):
    q = deque([(s,0)])
    while q:
        cur,cnt = q.popleft()
        if cur == e:
            return cnt
        for nxt,dis in graph[cur]:
            if parent[cur] == nxt:
                continue
            parent[nxt] = cur
            q.append((nxt,cnt+dis))
            
for _ in range(m):
    parent = defaultdict(int)
    s,e = map(int,input().split())
    print(bfs(s,e))         
    