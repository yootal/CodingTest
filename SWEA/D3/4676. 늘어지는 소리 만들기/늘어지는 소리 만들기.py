t = int(input())
for case in range(1, t + 1):
    s = list(input())
    h = int(input())
    idx = list(map(int, input().split()))
    add = [0] * (len(s) + 1)
    for i in idx:
        add[i] += 1
    ans = ''
    for j in range(len(s) + 1):
        if add[j] > 0:
            ans += '-' * add[j]
        if j < len(s):
            ans += s[j]
    print(f'#{case} {ans}')