import sys
input = sys.stdin.readline
from collections import defaultdict, deque

t = int(input())
for _ in range(t):
    n,m = map(int,input().split())
    graph = defaultdict(list)
    check = [False] * (n+1)
    for _ in range(m):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
        
    q = deque()
    check[1] = True
    for nxt in graph[1]:
        q.append((1,nxt))
    cnt = 0
    ans = 0
    while cnt < n - 1:
        x,nxt = q.popleft()
        if check[nxt]:
            continue
        ans += 1
        cnt += 1
        check[b] = True
        for nxt in graph[b]:
            if not check[nxt]:
                q.append((b,nxt))
    print(ans)
        