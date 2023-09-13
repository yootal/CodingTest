import sys
input=sys.stdin.readline
from collections import deque, defaultdict

dx,dy = [-1,1,0,0],[0,0,-1,1]    
n,m = map(int,input().split())
turn_info = defaultdict(list)

for _ in range(m):
    x,y,a,b = map(int,input().split())
    turn_info[(x-1, y-1)].append((a-1, b-1))
    
def bfs():
    ans_cnt = 1 # 켠 불
    visited = [[False] * n for _ in range(n)]
    lights = [[False] * n for _ in range(n)]
    visited[0][0] = True
    lights[0][0] = True
    q = deque([(0, 0)])
    while q:
        r, c = q.popleft()
        for tr, tc in turn_info[(r, c)]:
            if not lights[tr][tc]:
                lights[tr][tc] = True
                ans_cnt += 1
                for d in range(4):
                    nr = tr + dy[d]
                    nc = tc + dx[d]
                    if 0 <= nr < n and 0 <= nc < n:
                        if visited[nr][nc]:
                            q.append((nr, nc))
        
        for d in range(4):
            nr = r + dy[d]
            nc = c + dx[d]
            if 0 <= nr < n and 0 <= nc < n:
                if not visited[nr][nc] and lights[nr][nc]:
                    q.append((nr, nc))  
                    visited[nr][nc] = True

    return ans_cnt

print(bfs())