import sys
input=sys.stdin.readline
from collections import deque

n,l,w = map(int,input().split())
truck = deque(list(map(int,input().split())))
bridge = deque()

time = 0
weight = 0
while True:
    time += 1
    if len(bridge) > 0 and bridge[0][1] + l == time:
        t = bridge.popleft()
        weight -= t[0]
        if len(bridge) == 0 and len(truck) == 0:
            break
    if len(truck) > 0 and weight + truck[0] <= w:
        t = truck.popleft()
        bridge.append((t,time))
        weight += t
print(time)