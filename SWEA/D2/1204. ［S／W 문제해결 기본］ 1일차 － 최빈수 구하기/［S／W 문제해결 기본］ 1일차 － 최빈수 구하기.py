from collections import Counter

t = int(input())
for case in range(1, t + 1):
    n = int(input())
    num = list(map(int, input().split()))
    cnt = Counter(num)
    num.sort(key=lambda x: cnt[x])
    print(f'#{n} {num[-1]}')
