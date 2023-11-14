t = int(input())
for case in range(1, t + 1):
    n = int(input())
    price = list(map(int, input().split()))
    ans = 0
    max_cost = 0
    for i in range(n - 1, -1, -1):
        if max_cost < price[i]:
            max_cost = price[i]
        else:
            ans += max_cost - price[i]
    print(f'#{case} {ans}')