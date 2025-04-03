for i in range(int(input())):
    cnt = 0
    n, m = map(int, input().split())
    for j in range(n, m + 1):
        w = str(j)
        cnt += w.count('0')
    print(cnt)
