t = int(input())
for case in range(1, t + 1):
    s = list(input())
    n = len(s)
    flag = True
    for i in range(n // 2):
        if s[i] == '*' or s[(n - 1) - i] == '*':
            break
        if s[i] != s[(n - 1) - i]:
            flag = False
            break
    if flag:
        print(f'#{case} Exist')
    else:
        print(f'#{case} Not exist')