from sys import stdin
from collections import deque
input = stdin.readline

n = int(input())
crane = list(map(int,input().split()))
m = int(input())
box = list(map(int,input().split()))

crane.sort(reverse=True)
box.sort()
idx = 0
ans = 0

if crane[idx] < box[-1]:
    print(-1)
    exit()
    
while box:
    if idx == n:
        ans += 1
        idx = 0
        continue
    temp = deque()
    while box and crane[idx] < box[-1]:
        temp.appendleft(box.pop())
    if box:
        box.pop()
        idx += 1
    else:
        ans += 1
        idx = 0
    box.extend(temp)
ans += 1
print(ans)