for _ in range(int(input())):
    d, n, s, p = map(int, input().split())
    if d + p * n > n * s:
        print("do not parallelize")
    elif d + p * n < n * s:
        print("parallelize")
    else:
        print("does not matter")
