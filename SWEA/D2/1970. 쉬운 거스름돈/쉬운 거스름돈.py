cost = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
t = int(input())
for case in range(1, t + 1):
    cost_cnt = {i: 0 for i in cost}
    n = int(input())
    for i in cost:
        a, b = divmod(n, i)
        cost_cnt[i] = a
        n = b
    print(f"#{case}")
    print(*list(cost_cnt.values()))
