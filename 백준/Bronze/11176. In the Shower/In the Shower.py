for i in range(int(input())):
    e, n = map(int, input().split())
    cnt = 0
    for j in range(n):
        x = int(input())
        if x > e:
            cnt += 1
    print(cnt)
