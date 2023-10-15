from sys import stdin
from collections import deque
input = stdin.readline

for _ in range(int(input())):
    n = int(input())
    height = sorted(list(map(int,input().split())),reverse=True)
    ans = 0
    dq = deque()
    for i in range(n):
        if i % 2 == 0:
            if dq:
                ans = max(ans,abs(dq[0]-height[i]))
            dq.appendleft(height[i])
        else:
            ans = max(ans,abs(dq[-1]-height[i]))
            dq.append(height[i])
    ans = max(ans,abs(dq[0]-dq[-1]))
    print(ans)