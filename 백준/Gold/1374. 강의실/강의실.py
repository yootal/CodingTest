from sys import stdin
from heapq import heappush, heappop
input = stdin.readline        

n  = int(input())
schedule = []
for _ in range(n):
    num,s,e = map(int,input().split())
    schedule.append((s,e))
schedule.sort()

hq = []
for st, en in schedule:
    if hq and hq[0] <= st:
        heappop(hq)
    heappush(hq,en)

print(len(hq)) 