from collections import defaultdict

t = int(input())
for case in range(1, t + 1):
    s = list(input())
    cnt = defaultdict(int)
    for x in s:
        cnt[x] += 1
    key = tuple(cnt.keys())
    if len(key) == 2 and cnt[key[0]] == 2 and cnt[key[1]] == 2:
        print(f'#{case} Yes')
    else:
        print(f'#{case} No')