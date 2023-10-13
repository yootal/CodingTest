from sys import stdin
from collections import deque
input = stdin.readline

n = int(input())
pillar = []
highest = 0
for _ in range(n):
    l,h = map(int,input().split())
    highest = max(highest,h)
    pillar.append((l,h))
    
p = deque(sorted(pillar))

cur1 = p[0][0]
h1 = 0
total1 = 0
while True:
    if p[0][0] == cur1 and p[0][1] == highest:
        break
    if p[0][0] == cur1:
        l,h = p.popleft()
        if h > h1:
            h1 = h
    total1 += h1
    cur1 += 1

cur2 = p[-1][0]
h2 = 0
total2 = 0
while True:
    if p[-1][0] == cur2 and p[-1][1] == highest:
        break
    if p[-1][0] == cur2:
        l,h = p.pop()
        if h > h2:
            h2 = h
    total2 += h2
    cur2 -= 1
    
print(total1 + total2 + ((cur2-cur1+1)*highest))