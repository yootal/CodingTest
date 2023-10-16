from sys import stdin
from collections import defaultdict, deque
input = stdin.readline

n = int(input())
frinend = defaultdict(list)

def bfs(cur):
    vis[cur] = True
    dq = deque()
    dq.append((cur,0))
    while dq:
        x,d = dq.popleft()
        if d == 2:
            continue
        for i in frinend[x]:
            if not vis[i]:
                vis[i] = True
                dq.append((i,d+1))

for i in range(n):
    inp = list(input().rstrip())
    for j in range(n):
        if i == j:
            continue
        if inp[j] == 'Y':
            frinend[i].append(j)
            
ans = 0
for i in range(n):
    vis = [False] * n
    bfs(i)
    cnt = vis.count(True)
    ans = max(ans,cnt-1)

print(ans)