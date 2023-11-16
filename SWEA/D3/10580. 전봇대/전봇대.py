t = int(input())
for case in range(1, t + 1):
    n = int(input())
    line = []
    ans = 0
    for _ in range(n):
        a, b = map(int, input().split())
        for x, y in line:
            if a > x and b < y or a < x and b > y:
                ans += 1
        line.append((a, b))
    print(f'#{case} {ans}')