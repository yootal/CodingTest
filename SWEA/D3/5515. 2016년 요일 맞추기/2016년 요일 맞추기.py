from calendar import monthrange

t = int(input())
days = [monthrange(2016, x)[1] for x in range(1, 13)]
for case in range(1, t + 1):
    m, d = map(int, input().split())
    day = d + (4 - 1)
    for i in range(m - 1):
        day += days[i]
    print(f'#{case} {day % 7}')
