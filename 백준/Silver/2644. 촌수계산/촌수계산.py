from sys import stdin
from collections import defaultdict, deque
input = stdin.readline

n = int(input())
vis = [-1] * (n+1)
a,b = map(int,input().split())
m = int(input())
graph = defaultdict(list)
for _ in range(m):
    x,y = map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)
    
def bfs():
    vis[a] = 0
    dq = deque()
    dq.append(a)
    while dq:
        cur = dq.popleft()
        if cur == b:
            return vis[cur]
        for nxt in graph[cur]:
            if vis[nxt] == -1:
                vis[nxt] = vis[cur] + 1
                dq.append(nxt)
    return -1

print(bfs())