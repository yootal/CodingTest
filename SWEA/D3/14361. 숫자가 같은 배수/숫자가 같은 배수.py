t = int(input())
for case in range(1,t+1):
    inp = input().rstrip()
    n = int(inp)
    l = sorted(list(inp))
    llen = len(inp)
    flag = False
    k = 2
    while True:
        m = n * k
        if len(str(m)) > llen:
            break
        if sorted(list(str(m))) == l:
            flag = True
            break
        k += 1
    if flag:
        print(f'#{case} possible')
    else:
        print(f'#{case} impossible')