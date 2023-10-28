t = int(input())
for case in range(1, t + 1):
    s = list(input())
    ans = 0
    for i in range(len(s)):
        if s[i] == '(':
            ans += 1
        if s[i] == ')':
            if s[i - 1] != '(':
                ans += 1
    print(f'#{case} {ans}')
