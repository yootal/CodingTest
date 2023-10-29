t = int(input())
for case in range(1, t + 1):
    a = b = 1
    s = list(input())
    for x in s:
        if x == 'L':
            b = a + b
        if x == 'R':
            a = a + b
    print(f'#{case} {a} {b}')