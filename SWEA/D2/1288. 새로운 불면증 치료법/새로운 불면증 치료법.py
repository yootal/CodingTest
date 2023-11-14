t = int(input())
for case in range(1, t + 1):
    n = int(input())
    check = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
    count = 0
    value = n
    while check:
        count += 1
        num = str(value)
        for x in num:
            check.discard(int(x))
        value += n
    print(f"#{case} {count * n}")