t = int(input())
days = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
for case in range(1, t + 1):
    m, d = map(int, input().split())
    day = d + 3
    for i in range(m - 1):
        day += days[i]
    print(f'#{case} {day % 7}')