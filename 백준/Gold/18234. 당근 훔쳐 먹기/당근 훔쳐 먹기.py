from sys import stdin
from collections import defaultdict
input = stdin.readline

n,t = map(int,input().split())
carrot = defaultdict(tuple)
for i in range(n):
    carrot[i] = tuple(map(int,input().split()))
priority = sorted(list(range(n)),key=lambda x: (carrot[x][1],carrot[x][0]))

ans = 0
idx = 0
for day in range(t - n + 1,t+1):
    cur = priority[idx]
    ans += carrot[cur][0] + carrot[cur][1] * (day - 1)
    idx += 1        
print(ans)
    