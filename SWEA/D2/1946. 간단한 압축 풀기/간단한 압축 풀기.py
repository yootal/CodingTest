t = int(input())
for case in range(1, t + 1):
    n = int(input())
    s = ''
    for _ in range(n):
        a, b = input().split()
        s += a * int(b)
    print(f"#{case}")
    for i in range(0, len(s), 10):
        print(s[i:i + 10])
