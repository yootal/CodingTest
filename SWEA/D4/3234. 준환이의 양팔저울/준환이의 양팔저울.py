from math import factorial


def back_tracking(left, right, cnt):
    global ans
    if cnt == n:
        ans += 1
        return
    if left > sum_w // 2:
        ans += (2 ** (n - cnt)) * factorial(n - cnt)
        return
    for i in range(n):
        if not vis[i]:
            vis[i] = True
            back_tracking(left + w[i], right, cnt + 1)
            if left >= right + w[i]:
                back_tracking(left, right + w[i], cnt + 1)
            vis[i] = False


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    w = list(map(int, input().split()))
    sum_w = sum(w)
    vis = [False] * n
    ans = 0
    back_tracking(0, 0, 0)
    print(f'#{case} {ans}')
