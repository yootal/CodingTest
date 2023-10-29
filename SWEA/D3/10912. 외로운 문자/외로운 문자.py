from collections import defaultdict

t = int(input())
for case in range(1, t + 1):
    s = list(input())
    cnt = defaultdict(int)
    for a in s:
        cnt[a] += 1
    result = []
    for k, v in sorted(cnt.items(), key=lambda x: x[0]):
        if v % 2 == 1:
            result.append(k)
    if not result:
        print(f'#{case} Good')
    else:
        print(f'#{case}', ''.join(result))