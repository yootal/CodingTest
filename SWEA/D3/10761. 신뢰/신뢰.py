t = int(input())
for case in range(1, t + 1):
    inp = list(input().split())
    n = inp[0]
    info = {'O': [1, 0], 'B': [1, 0]}
    ans = 0
    for i in range(1, len(inp), 2):
        u = inp[i]
        nxt = int(inp[i + 1])
        gap = abs(nxt - info[u][0])
        time = ans - info[u][1]
        if gap <= time:
            ans += 1
        else:
            ans += gap - time + 1
        info[u] = [nxt, ans]
    print(f'#{case} {ans}')