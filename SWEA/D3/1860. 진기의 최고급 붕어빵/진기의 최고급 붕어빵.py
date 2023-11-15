t = int(input())
for case in range(1, t + 1):
    n, m, k = map(int, input().split())
    arrive = sorted(list(map(int, input().split())))
    for cur in range(n):
        if (arrive[cur] // m) * k - cur <= 0:
            print(f"#{case} Impossible")
            break
    else:
        print(f"#{case} Possible")