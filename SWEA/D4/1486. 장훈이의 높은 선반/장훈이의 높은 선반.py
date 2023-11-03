from itertools import combinations

t = int(input())
for case in range(1, t + 1):
    n, b = map(int, input().split())
    s = list(map(int, input().split()))
    ans = 1e9
    for i in range(1, n + 1):
        for comb in combinations(s, i):
            total = sum(comb)
            if total >= b:
                ans = min(ans, total)
    print(f'#{case} {ans - b}')
