t = int(input())
for case in range(1, t + 1):
    s = input()
    if s == s[::-1]:
        print(f'#{case} 1')
    else:
        print(f'#{case} 0')
