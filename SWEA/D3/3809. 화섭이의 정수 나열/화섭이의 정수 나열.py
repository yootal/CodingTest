t = int(input())
for case in range(1, t + 1):
    n = int(input())
    s = ''
    while len(s) != n:
        inp = list(input().split())
        for x in inp:
            s += x
    num = 0
    while True:
        c = str(num)
        c_len = len(c)
        for i in range(n - c_len + 1):
            if s[i:i + c_len] == c:
                break
        else:
            print(f'#{case} {num}')
            break
        num += 1
