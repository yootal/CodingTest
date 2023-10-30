t = int(input())
for case in range(1, t + 1):
    inp = list(input().split())
    n = int(inp[0])
    ans = {'O': [1, 0], 'B': [1, 0]}
    cnt = 0
    for i in range(1, n * 2, 2):
        cur = inp[i]
        p = int(inp[i + 1])
        gap = abs(p - ans[cur][0])
        time = cnt - ans[cur][1]
        if gap <= time:
            cnt += 1
        else:
            cnt += gap - time + 1
        ans[cur] = [p, cnt]
    print(f'#{case} {cnt}')