t = int(input())
for case in range(1, t + 1):
    n = int(input())
    size = []
    for _ in range(n):
        size.append(int(input()))
    avg = sum(size) // n
    ans = 0
    for x in size:
        if x > avg:
            ans += x - avg
    print(f'#{case} {ans}')
