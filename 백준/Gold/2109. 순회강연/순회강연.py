from sys import stdin
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline
    
n = int(input())
day = defaultdict(list)
last = 0
for _ in range(n):
    p,d = map(int,input().split())
    day[d].append(p)
    last = max(last,d)

ans = 0
hq = []
while last > 0:
    for p in day[last]:
        heappush(hq,-p)
    if hq:
        ans += -heappop(hq)
    last -= 1
print(ans)
         