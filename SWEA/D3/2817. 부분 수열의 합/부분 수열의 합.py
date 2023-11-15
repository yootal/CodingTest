from itertools import combinations

t = int(input())
for case in range(1, t + 1):
    n, k = map(int, input().split())
    num = list(map(int, input().split()))
    ans = 0
    for i in range(1, len(num) + 1):
        for value in combinations(num, i):
            if sum(value) == k:
                ans += 1

    print(f'#{case} {ans}')