t = int(input())
for case in range(1, t + 1):
    s = list(input())
    h = int(input())
    idx = list(map(int, input().split()))
    idx.sort(reverse=True)
    for i in idx:
        s.insert(i, '-')
    ans = ''.join(s)
    print(f'#{case} {ans}')
