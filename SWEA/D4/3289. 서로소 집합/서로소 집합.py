def find(x):
    if x != parent[x]:
        return find(parent[x])
    return x


def union(x, y):
    x = find(x)
    y = find(y)
    if x == y:
        return
    if x > y:
        parent[x] = y
    else:
        parent[y] = x
    return


t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    parent = list(range(n + 1))
    ans = ''
    for _ in range(m):
        c, a, b = map(int, input().split())
        if c == 0:
            union(a, b)
        else:
            if find(a) == find(b):
                ans += '1'
            else:
                ans += '0'
    print(f'#{case} {ans}')
