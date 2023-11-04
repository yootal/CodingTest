def calc():
    global ans
    a = [0, 0]
    b = [0, 0]
    for i in range(n):
        if vis[i]:
            a[0] += p[i][0]
            a[1] += p[i][1]
        else:
            b[0] += p[i][0]
            b[1] += p[i][1]
    ans = min(ans, (a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2)


def comb(idx, cnt):
    if cnt == n // 2:
        calc()
        return
    for i in range(idx, n):
        vis[i] = True
        comb(i + 1, cnt + 1)
        vis[i] = False


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    p = [tuple(map(int, input().split())) for _ in range(n)]
    vis = [False] * n
    ans = 1e15
    comb(0, 0)
    print(f'#{case} {ans}')
