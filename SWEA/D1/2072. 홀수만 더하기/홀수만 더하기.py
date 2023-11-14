t = int(input())
for case in range(1, t + 1):
    ans = 0
    for x in list(map(int, input().split())):
        if x % 2:
            ans += x
    print(f'#{case} {ans}')
