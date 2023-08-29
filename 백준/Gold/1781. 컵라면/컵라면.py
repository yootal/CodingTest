import sys
from heapq import heappush, heappop
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
cup_ramen = defaultdict(list)

for i in range(1,n+1):
    d,a = map(int,input().split())
    cup_ramen[d].append(-a)

total = 0
find_max = []
for i in range(n,0,-1):
    for a in cup_ramen[i]:
        heappush(find_max,a)
    if find_max:
        total += -heappop(find_max)

print(total)
    