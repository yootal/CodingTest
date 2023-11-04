from collections import defaultdict
from heapq import heappush, heappop


def calc_cost(p1, p2):
    dist = ((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2)
    return e * dist


def prim():
    total = 0
    hq = []
    heappush(hq, (0, 0))
    while hq:
        cost, cur = heappop(hq)
        if vis[cur]:
            continue
        vis[cur] = True
        total += cost
        for cost2, nxt in route[cur]:
            heappush(hq, (cost2, nxt))
    return total


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    pos_x = list(map(int, input().split()))
    pos_y = list(map(int, input().split()))
    e = float(input())
    route = defaultdict(list)
    for i in range(n - 1):
        for j in range(i + 1, n):
            c = calc_cost((pos_x[i], pos_y[i]), (pos_x[j], pos_y[j]))
            route[i].append((c, j))
            route[j].append((c, i))
    vis = [False] * n
    ans = round(prim())
    print(f'#{case} {ans}')
