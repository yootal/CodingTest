t = int(input())
result = []
for case in range(1, t + 1):
    a1, a2, b1, b2 = map(int, input().split())
    st = max(a1, b1)
    en = min(a2, b2)
    t = en - st
    if t < 0:
        t = 0
    result.append(f'#{case} {t}')
for ans in result:
    print(ans)