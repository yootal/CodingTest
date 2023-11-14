n = int(input())
c = {3, 6, 9}
for i in range(1, n + 1):
    s = str(i)
    cnt = 0
    for x in s:
        if int(x) in c:
            cnt += 1
    if not cnt:
        print(i, end=' ')
    else:
        print('-' * cnt, end=' ')