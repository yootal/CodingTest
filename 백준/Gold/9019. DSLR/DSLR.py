from sys import stdin
from collections import deque
input = stdin.readline

def bfs(x):
    dq = deque([(x,[])])
    vis = [False] * 10000
    vis[x] = True
    while dq:
        cur,ans = dq.popleft()

        if cur == b:
            return ''.join(ans)
                
        x2 = cur * 2 % 10000
        if not vis[x2]:
            vis[x2] = True
            dq.append((x2,ans + ['D']))

        x3 = (cur - 1) % 10000        
        if not vis[x3]:
            vis[x3] = True
            dq.append((x3,ans + ['S']))
        
        x4 = cur // 1000 + (cur % 1000) * 10
        if not vis[x4]:
            vis[x4] = True
            dq.append((x4,ans + ['L']))
        
        x5 = cur // 10 + (cur % 10) * 1000
        if not vis[x5]:
            vis[x5] = True
            dq.append((x5,ans + ['R']))

t = int(input())
for _ in range(t):
    a,b = map(int,input().split())
    print(bfs(a))
