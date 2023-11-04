from collections import defaultdict, deque


def bfs(cur):
    vis[cur] = True
    dq = deque([cur])
    while dq:
        x = dq.popleft()
        for nxt in graph[x]:
            if not vis[nxt]:
                vis[nxt] = True
                dq.append(nxt)


t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    graph = defaultdict(list)
    vis = [False] * (n + 1)
    for _ in range(m):
        s, e = map(int, input().split())
        graph[s].append(e)
        graph[e].append(s)
    ans = 0
    for i in range(1, n + 1):
        if not vis[i]:
            ans += 1
            bfs(i)
    print(f'#{case} {ans}')
