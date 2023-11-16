from collections import defaultdict

t = int(input())
for case in range(1, t + 1):
    s = input()
    cnt = defaultdict(int)
    for x in s:
        cnt[x] += 1
    ans = []
    for k, v in cnt.items():
        if v % 2:
            ans.append(k)
    if not ans:
        print(f'#{case} Good')
    else:
        ans = ''.join(sorted(ans))
        print(f'#{case} {ans}')
