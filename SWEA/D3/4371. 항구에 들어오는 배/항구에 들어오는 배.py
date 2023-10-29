from collections import defaultdict

t = int(input())
for case in range(1, t + 1):
    n = int(input())
    happy = []
    check = defaultdict(bool)
    for _ in range(n):
        day = int(input())
        happy.append(day)
        check[day] = False
    check[1] = True
    ans = 0
    for i in range(1, n):
        if not check[happy[i]]:
            check[happy[i]] = True
            ans += 1
            gap = happy[i] - 1
            for j in range(i + 1, n):
                if (happy[j] - happy[i]) % gap == 0:
                    check[happy[j]] = True
    print(f'#{case} {ans}')
