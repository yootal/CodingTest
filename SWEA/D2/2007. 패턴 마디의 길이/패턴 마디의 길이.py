t = int(input())
for test_case in range(1, t + 1):
    s = input()
    for i in range(1, 10):
        if s[:i] == s[i:2 * i]:
            print(f'#{test_case} {i}')
            break