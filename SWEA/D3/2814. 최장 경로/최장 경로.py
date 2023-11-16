from collections import defaultdict


def dfs(cur, d):
    global ans
    ans = max(ans, d)
    for nxt in graph[cur]:
        if not vis[nxt]:
            vis[nxt] = True
            dfs(nxt, d + 1)
            vis[nxt] = False


t = int(input())
for case in range(1, t + 1):
    graph = defaultdict(list)
    n, m = map(int, input().split())
    for _ in range(m):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)
    vis = [False] * (n + 1)
    ans = 1
    for i in range(1, n + 1):
        vis[i] = True
        dfs(i, 1)
        vis[i] = False
    print(f'#{case} {ans}')
