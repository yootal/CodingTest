from sys import stdin
input = stdin.readline

for _ in range(int(input())):
    x,y = map(int,input().split())
    diff = y - x
    cnt = 0
    move = 1
    total = 0
    while diff > total:
        cnt += 1
        total += move
        if cnt % 2 == 0:
            move += 1
    print(cnt)