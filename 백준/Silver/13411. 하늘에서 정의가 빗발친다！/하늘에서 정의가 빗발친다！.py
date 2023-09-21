import sys
from heapq import heappush, heappop
input = sys.stdin.readline

q = []
n = int(input())
for i in range(1,n+1):
    x,y,s = map(int,input().split())
    t = (x**2 + y**2)**0.5 / s
    heappush(q,(t,i))

while q:
    t,i = heappop(q)
    print(i)
    

    