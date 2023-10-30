def back_tracking(w, cnt):
    global ans
    if w < 0:
        return
    if w >= 0 and cnt == n:
        ans += 1
    for i in range(n):
        if not vis[i]:
            vis[i] = True
            back_tracking(w - k + kit[i], cnt + 1)
            vis[i] = False


n, k = map(int, input().split())
kit = list(map(int, input().split()))
vis = [False] * n
ans = 0
back_tracking(0, 0)
print(ans)