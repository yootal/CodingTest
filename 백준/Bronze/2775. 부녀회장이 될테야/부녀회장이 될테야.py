from sys import stdin
input = stdin.readline

for _ in range(int(input())):
    k = int(input())
    n = int(input())
    cnt = list(range(1,n+1))
    for _ in range(k):
        for j in range(1,n):
            cnt[j] += cnt[j-1]
    print(cnt[-1])