import sys
input=sys.stdin.readline

# 0북 1동 2남 3서
dx,dy = [0,0,-1,1],[-1,1,0,0]

def sum_value(tet):
    global max_value
    total = 0
    for t1,t2 in tet:
        total += board[t1][t2]
    max_value = max(max_value,total)

def tet_backT(i,j,tet):
    if len(tet) == 4:
        sum_value(tet)
        return
    for k in range(4):
        nx = i + dx[k]
        ny = j + dy[k]
        if 0 <= nx < N and 0 <= ny < M and (nx,ny) not in tet:
                tet.append((nx,ny))
                tet_backT(nx,ny,tet)
                if len(tet) < 4:
                    for k2 in range(4):
                        nx2 = i + dx[k2]
                        ny2 = j + dy[k2]
                        if 0 <= nx2 < N-1 and 0 <= ny2 < M-1 and (nx2,ny2) not in tet:
                            tet.append((nx2,ny2))
                            tet_backT(nx2,ny2,tet)
                            if len(tet) < 4:
                                for k3 in range(4):
                                    nx3 = i + dx[k3]
                                    ny3 = j + dy[k3]
                                    if 0 <= nx3 < N-1 and 0 <= ny3 < M-1 and (nx3,ny3) not in tet:
                                        tet.append((nx3,ny3))
                                        tet_backT(nx3,ny3,tet)
                                        tet.pop()
                            tet.pop()
                tet.pop()
    return

N,M = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(N)]
max_value = 0

for i in range(N):
    for j in range(M):
        tet_backT(i,j,[(i,j)])
        
print(max_value)