t = int(input())
for case in range(1, t + 1):
    n = int(input())
    s = input()
    if len(s) % 2 == 0 and s[:n // 2] == s[n // 2:]:
        print(f'#{case} Yes')
    else:
        print(f'#{case} No')