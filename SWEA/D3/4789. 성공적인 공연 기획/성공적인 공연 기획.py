t = int(input())
for case in range(1, t + 1):
    s = list(input())
    ans = 0
    cnt = 0
    for i in range(len(s)):
        if i > cnt:
            ans += i - cnt
            cnt += i - cnt
        cnt += int(s[i])
    print(f'#{case} {ans}')