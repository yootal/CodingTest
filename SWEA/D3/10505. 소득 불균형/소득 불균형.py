t = int(input())
for case in range(1, t + 1):
    n = int(input())
    income = list(map(int, input().split()))
    avg = sum(income) / n
    ans = sum(1 for item in income if item <= avg)
    print(f'#{case} {ans}')