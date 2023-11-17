t = int(input())
for case in range(1, t + 1):
    clap = list(map(int, input()))
    ans = 0
    customer = 0
    for i in range(len(clap)):
        if i > customer:
            diff = i - customer
            customer += diff
            ans += diff
        customer += clap[i]
    print(f'#{case} {ans}')
