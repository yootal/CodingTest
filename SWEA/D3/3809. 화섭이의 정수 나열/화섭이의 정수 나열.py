t = int(input())
for case in range(1, t + 1):
    n = int(input())
    s = ""
    while len(s) != n:
        inp = list(input().split())
        for x in inp:
            s += x
    cur = 0
    while True:
        c = str(cur)
        c_len = len(c)
        flag = False
        for i in range(n - (c_len - 1)):
            if s[i:i + c_len] == c:
                flag = True
                break
        if not flag:
            print(f'#{case} {cur}')
            break
        cur += 1
