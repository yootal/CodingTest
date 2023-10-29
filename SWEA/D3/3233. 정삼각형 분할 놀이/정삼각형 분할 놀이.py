t = int(input())
for case in range(1, t + 1):
    a, b = map(int, input().split())
    ans = (a // b) ** 2
    print(f'#{case} {ans}')