def check():
    global ans
    for x in range(a, b + 1):
        s1 = str(x)
        if s1 == s1[::-1]:
            x2 = int(x ** 0.5)
            if x2 ** 2 == x:
                s2 = str(x2)
                if s2 == s2[::-1]:
                    ans += 1


t = int(input())
for case in range(1, t + 1):
    a, b = map(int, input().split())
    ans = 0
    check()
    print(f'#{case} {ans}')