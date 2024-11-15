for _ in range(int(input())):
    p, t = map(int, input().split())
    print((t // 4) + p - (t // 7))