from sys import stdin
from heapq import heappush, heappop
input = stdin.readline        

n  = int(input())
time = sorted([tuple(map(int,input().split())) for _ in range(n)])

hq = []
ans = 0
for st, en in time:
    if hq and hq[0] <= st:
        heappop(hq)
    heappush(hq,en)

print(len(hq)) 
