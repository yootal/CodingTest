t = int(input())
for case in range(1, t + 1):
    n, k = map(int, input().split())
    score = sorted(list(map(int, input().split())))
    ans = 0
    for _ in range(k):
        ans += score.pop()
    print(f"#{case} {ans}")