import sys
input = sys.stdin.readline

n,m = map(int,input().split())
num = [int(input()) for _ in range(n)]
num.sort()

ans = sys.maxsize
en = 0
for st in range(n):
    while en < n and num[en] - num[st] < m:
        en += 1
    if en == n:
        break
    ans = min(ans, num[en] - num[st])
print(ans)