t = int(input())
for case in range(1, t + 1):
    n = int(input())
    result = []
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            result.append(i)
    ans = [0] * 2
    ans[0] = max(result)
    ans[1] = n // ans[0]
    print(f'#{case} {sum(ans) - 2}')