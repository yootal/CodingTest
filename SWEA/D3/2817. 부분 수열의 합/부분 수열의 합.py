def check(st, total):
    global ans
    if total == k:
        ans += 1
        return
    if total > k:
        return
    for i in range(st, n):
        if not vis[i]:
            vis[i] = True
            check(i + 1, total + num[i])
            vis[i] = False


t = int(input())
for case in range(1, t + 1):
    n, k = map(int, input().split())
    num = list(map(int, input().split()))
    vis = [False] * n
    ans = 0
    check(0, 0)
    print(f"#{case} {ans}")