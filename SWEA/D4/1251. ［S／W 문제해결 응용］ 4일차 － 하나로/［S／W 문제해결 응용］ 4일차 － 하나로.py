from heapq import heappush, heappop


def calc_cost(p1, p2):
    dist = ((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2)
    return e * dist


def find(cur):
    if parent[cur] != cur:
        cur = find(parent[cur])
    return cur


def union(x, y):
    x = find(x)
    y = find(y)
    if x == y:
        return False
    if x > y:
        parent[x] = y
    else:
        parent[y] = x
    return True


def kruskal(hq):
    total = 0
    while hq:
        cost, a, b = heappop(hq)
        if not union(a, b):
            continue
        total += cost
    return total


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    pos_x = list(map(int, input().split()))
    pos_y = list(map(int, input().split()))
    e = float(input())
    parent = list(range(n))
    route = []
    for i in range(n - 1):
        for j in range(i + 1, n):
            c = calc_cost((pos_x[i], pos_y[i]), (pos_x[j], pos_y[j]))
            heappush(route, (c, i, j))
    ans = round(kruskal(route))
    print(f'#{case} {ans}')