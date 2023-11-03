t = int(input())
for case in range(1, t + 1):
    n = int(input())
    room = []
    for _ in range(n):
        m = sorted(list(map(int, input().split())))
        room.append(m)
    cnt = [0] * 201
    for s, e in room:
        st = (s + 1) // 2
        ed = (e + 1) // 2
        for i in range(st, ed + 1):
            cnt[i] += 1
    ans = max(cnt)
    print(f'#{case} {ans}')