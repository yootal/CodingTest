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
    result = 1      # 불 켤 수 있는 방의 갯수
    visited = [[0] * n for _ in range(n)]   # 방문 표시
    visited[0][0] = 1
    lights = [[0] * n for _ in range(n)]    # 불 켠 방 표시
    lights[0][0] = 1
    Q = deque([(0, 0)])
    while Q:
        r, c = Q.popleft()
        for tr, tc in turn_info[(r, c)]:   # 불 켤 수 있는 곳(딕셔너리 참조)
            if not lights[tr][tc]:
                lights[tr][tc] = 1      # 새로 불 켜기
                result += 1
                for d in range(4):      # 4방향 연결된 곳
                    nr = tr + dy[d]
                    nc = tc + dx[d]
                    if not (0 <= nr < n and 0 <= nc < n):
                        continue
                    if visited[nr][nc]:     # 방문한 적 있으면(새로 연결되어 또 불을 켤 곳이 있을 수 있으므로)
                        Q.append((nr, nc))  # 큐에 담기
        
        # 현 위치를 기준으로
        for d in range(4):      # 4방향 연결된 곳
            nr = r + dy[d]
            nc = c + dx[d]
            if not (0 <= nr < n and 0 <= nc < n):
                continue
            # 첫 방문인데 이미 불 켜진 곳이면
            if not visited[nr][nc] and lights[nr][nc]:
                Q.append((nr, nc))      # 재검사를 위해 큐에 담기
                visited[nr][nc] = 1     # 방문 표시
    
    return result

print(bfs())
                
     

