for _ in range(int(input())):
    n, c = map(int, input().split())
    v = n // c
    if n % c > 0:
        v += 1
    print(v)
