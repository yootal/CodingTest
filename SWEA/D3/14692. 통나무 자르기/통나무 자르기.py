t = int(input())
for case in range(1, t + 1):
    n = int(input())
    if n % 2 == 0:
        ans = 'Alice'
    else:
        ans = 'Bob'
    print(f'#{case} {ans}')