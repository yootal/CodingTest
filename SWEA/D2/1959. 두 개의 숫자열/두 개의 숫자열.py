t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    num1 = list(map(int, input().split()))
    num2 = list(map(int, input().split()))
    ans = 0
    if n > m:
        n, m = m, n
        num1, num2 = num2, num1
    for i in range(m - n + 1):
        total = 0
        for j in range(n):
            total += num1[j] * num2[i + j]
        ans = max(ans, total)
    print(f'#{case} {ans}')
