from collections import deque, defaultdict


def bfs(x):
    dq = deque()
    dq.append((x, 0))
    while dq:
        cur, d = dq.popleft()
        for nxt in list(graph[cur]):
            if nxt not in vis:
                vis.add(nxt)
                dq.append((nxt, d + 1))
                depth[d + 1].append(nxt)


for case in range(1, 11):
    graph = defaultdict(set)
    depth = defaultdict(list)
    vis = set()
    n, st = map(int, input().split())
    inp = list(map(int, input().split()))
    for i in range(0, n, 2):
        graph[inp[i]].add(inp[i + 1])
    vis.add(st)
    bfs(st)
    max_key = 0
    for k in depth.keys():
        max_key = max(max_key, k)
    ans = max(depth[max_key])
    print(f'#{case} {ans}')