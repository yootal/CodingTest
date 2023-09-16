import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
m = int(input())
pw_list = list(map(int,input().split()))

dist = [-1] * (n+1)

q = deque()
for pw in pw_list:
    dist[pw] = 0
    q.append(pw)

ans = 0
while q:
    x = q.popleft()
    for i in range(20):
        nx = x ^ (1<<i)
        if nx > n or dist[nx] != -1:
            continue
        dist[nx] = dist[x] + 1
        ans = max(ans,dist[nx])
        q.append(nx)
        
print(ans)