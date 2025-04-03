cnt = [0] * 3
for _ in range(int(input())):
    a, b, c = map(int, input().split())
    cnt[0] += a
    cnt[1] += b
    cnt[2] += c
    m = min(cnt)
    if m >= 30:
        print(m)
        cnt[0] -= m
        cnt[1] -= m
        cnt[2] -= m
    else:
        print("NO")
