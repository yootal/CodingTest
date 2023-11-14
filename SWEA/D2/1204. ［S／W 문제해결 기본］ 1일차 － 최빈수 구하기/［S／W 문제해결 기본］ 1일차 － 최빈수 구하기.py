from collections import Counter

t = int(input())
for case in range(1, t + 1):
    n = int(input())
    num = list(map(int, input().split()))
    cnt = Counter(num)
    max_cnt = 0
    ans = 0
    for k, v in cnt.items():
        if max_cnt < v:
            max_cnt = v
            ans = k
        elif max_cnt == v:
            ans = max(ans, k)
    print(f'#{n} {ans}')
