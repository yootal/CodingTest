import sys
input=sys.stdin.readline
from collections import deque

def bfs():
    global k
    vis[0][n] = 0
    q = deque()
    q.append((n,0)) # 위치, 시간
    
    while q:
        
        x, t = q.popleft()
        nvt = t + 1
        
        for i in (x*2,x+1,x-1):
            if i < 0 or i > 500000:
                continue
            if vis[nvt % 2][i] != -1:
                continue
            vis[nvt % 2][i] = nvt
            q.append((i,nvt))
            
    found = False
    ans = 0
    while k <= 500000:
        if vis[ans % 2][k] <= ans:
            found = True
            break
        ans += 1
        k += ans
        
    if found:
        print(ans)
        return
    else:
        print(-1)
        return
                
n,k = map(int,input().split())
vis = [[-1] * 500001 for _ in range(2)] # 짝수, 홀수 초에 도착 기록
bfs()