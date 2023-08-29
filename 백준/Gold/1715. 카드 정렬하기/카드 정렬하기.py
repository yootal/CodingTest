import sys
from heapq import heappop, heappush
input = sys.stdin.readline

n = int(input())
card = []
for _ in range(n):
    heappush(card,int(input()))

ans = 0
while len(card) != 1:
    a = heappop(card)
    b = heappop(card)
    ans += (a+b)
    heappush(card, a+b)
print(ans)