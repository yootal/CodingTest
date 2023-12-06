from sys import stdin
from collections import defaultdict, deque
input = stdin.readline

n = int(input())
graph = defaultdict(list)

for _ in range(n-1):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)
a,b,c = map(int,input().split())
vis = [False] * (n+1)
dist_b = [-1] * (n+1)
dist_c = [-1] * (n+1)

def bfs(x,who):
    if who == 1:
        dist = dist_b
    elif who == 2:
        dist = dist_c
    dq = deque()
    dist[x] = 0
    dq.append(x)
    while dq:
        cur = dq.popleft()
        for nxt in graph[cur]:
            if dist[nxt] == -1:
                dist[nxt] = dist[cur] + 1
                dq.append(nxt)
                
def bfs_yoon(x):
    dq = deque()
    dq.append((x,0))
    vis[x] = True
    while dq:
        cur,time = dq.popleft()
        if len(graph[cur]) == 1:
            return True
        for nxt in graph[cur]:
            if not vis[nxt] and time + 1 < dist_b[nxt] and time + 1 < dist_c[nxt]:
                vis[nxt] = True
                dq.append((nxt,time+1))
    return False

bfs(b,1)
bfs(c,2)
print('YES' if bfs_yoon(a) else 'NO')