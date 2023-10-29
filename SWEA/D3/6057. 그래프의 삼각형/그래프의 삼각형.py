from collections import defaultdict

t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    graph = defaultdict(set)
    ans = 0
    for _ in range(m):
        x, y = map(int, input().split())
        for nxt in graph[x]:
            if y in graph[nxt]:
                ans += 1
        graph[x].add(y)
        graph[y].add(x)
    print(f'#{case} {ans}')
