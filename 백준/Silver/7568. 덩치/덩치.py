from sys import stdin
input = stdin.readline

n = int(input())
stat = [tuple(map(int,input().split())) for _ in range(n)]
for i in range(n):
    cnt = 1
    for j in range(n):
        if stat[i][0] < stat[j][0] and stat[i][1] < stat[j][1]:
            cnt += 1
    print(cnt,end=' ')
        