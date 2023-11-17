from collections import defaultdict


def init():
    cur = 1
    x, y = 1, 1
    nxt = 2
    while y <= 300:
        pos[cur] = (x, y)
        num[(x, y)] = cur
        cur += 1
        y -= 1
        if y == 0:
            x = 1
            y = nxt
            nxt += 1
            continue
        x += 1


pos = defaultdict(tuple)
num = defaultdict(int)
init()
t = int(input())
for case in range(1, t + 1):
    p, q = map(int, input().split())
    pos_p = pos[p]
    pos_q = pos[q]
    temp = (pos_p[0] + pos_q[0], pos_p[1] + pos_q[1])
    ans = num[temp]
    print(f'#{case} {ans}')
