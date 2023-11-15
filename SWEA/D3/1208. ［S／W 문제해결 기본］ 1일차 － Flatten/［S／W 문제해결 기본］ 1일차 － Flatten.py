for case in range(1, 11):
    n = int(input())
    height = list(map(int, input().split()))
    for _ in range(n):
        _max = max(height)
        _min = min(height)
        if _max - _min < 2:
            break
        height[height.index(_max)] -= 1
        height[height.index(_min)] += 1
    ans = max(height) - min(height)
    print(f"#{case} {ans}")
