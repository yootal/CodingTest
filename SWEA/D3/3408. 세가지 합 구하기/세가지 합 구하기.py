t = int(input())
for case in range(1, t + 1):
    n = int(input())
    s1 = (n * (2 + (n - 1))) // 2
    s2 = (n * (2 + (n - 1) * 2)) // 2
    s3 = (n * (4 + (n - 1) * 2)) // 2
    print(f'#{case} {s1} {s2} {s3}')
