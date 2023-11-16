t = int(input())
for case in range(1, t + 1):
    n = int(input())
    happy = []
    for _ in range(n):
        happy.append(int(input()))
    ships = set()
    ans = 0
    for i in range(1, n):
        if happy[i] in ships:
            continue
        gap = happy[i] - 1
        for j in range(1 + gap, happy[-1] + 1, gap):
            ships.add(j)
        ans += 1
    print(f'#{case} {ans}')
