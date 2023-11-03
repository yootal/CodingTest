from collections import defaultdict


def dfs(cur):
    global ans
    if cur == 99:
        ans = 1
        return
    for nxt in graph[cur]:
        dfs(nxt)


for _ in range(10):
    case, n = map(int, input().split())
    inp = list(map(int, input().split()))
    graph = defaultdict(list)
    for i in range(0, n * 2, 2):
        graph[inp[i]].append(inp[i + 1])
    ans = 0
    dfs(0)
    print(f'#{case} {ans}')
