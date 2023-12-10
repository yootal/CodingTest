from sys import stdin
from heapq import heappush, heappop
input = stdin.readline

n = int(input())
info = []
for _ in range(n):
    heappush(info,tuple(map(int,input().split())))
l,p = map(int,input().split())

ans = 0
charge = []
while p < l:
    while info and info[0][0] <= p:
        point,fuel = heappop(info)
        heappush(charge,-fuel)
    if not charge:
        ans = -1
        break
    max_fuel = heappop(charge)
    p += -max_fuel
    ans += 1
print(ans)