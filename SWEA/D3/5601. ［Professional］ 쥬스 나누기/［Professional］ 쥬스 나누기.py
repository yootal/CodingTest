t = int(input())
for case in range(1, t + 1):
    n = int(input())
    print(f"#{case}", end=" ")
    for _ in range(n):
        print(f'1/{n}', end=" ")
    print()