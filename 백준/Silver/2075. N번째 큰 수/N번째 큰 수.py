import sys
from heapq import heappop, heappush
input = sys.stdin.readline

n = int(input())
hq = []
for _ in range(n):
    num = list(map(int,input().split()))
    for num2 in num:
        if len(hq) < n:
            heappush(hq,num2)
        else:
            if hq[0] < num2:
                heappop(hq)
                heappush(hq,num2)

if hq: 
    print(hq[0])