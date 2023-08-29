import sys
from heapq import heappop, heappush
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    k = int(input())
    cp = list(map(int,input().split()))
    h = []
    for cp2 in cp:
        heappush(h,cp2)
    ans = 0
    while len(h) != 1:
        a = heappop(h)
        b = heappop(h)
        ans += (a+b)
        heappush(h,a+b)
    print(ans)
