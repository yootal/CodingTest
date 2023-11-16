t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    total = n + m
    nl = list(input().split())
    ml = list(input().split())
    all = nl + ml
    ans = total - len(set(all))
    print(f'#{case} {ans}')