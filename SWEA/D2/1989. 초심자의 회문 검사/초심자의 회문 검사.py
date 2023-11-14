t = int(input())
for case in range(1, t + 1):
    s = input()
    for i in range(len(s) // 2):
        if s[i] != s[-1 - i]:
            ans = 0
            break
        else:
            ans = 1
    print(f'#{case} {ans}')
