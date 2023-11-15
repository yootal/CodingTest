from itertools import combinations

t = int(input())
for case in range(1, t + 1):
    N, L = map(int, input().split())
    data = [tuple(map(int, input().split())) for _ in range(N)]
    ans = 0
    for i in range(1, N + 1):
        for value in combinations(data, i):
            calorie = 0
            score = 0
            for v in range(len(value)):
                calorie += value[v][1]
                score += value[v][0]
            if calorie > L:
                continue
            if ans < score:
                ans = score
    print(f"#{case} {ans}")
