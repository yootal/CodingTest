import sys
input = sys.stdin.readline
from collections import defaultdict

n,m,k = map(int,input().split())
hell = [input().rstrip() for _ in range(n)]
god = [input().rstrip() for _ in range(k)]
cnt_save = defaultdict(int)
dx = [-1,1,0,0,-1,1,-1,1]
dy = [0,0,-1,1,-1,1,1,-1]

def dfs(x,y,depth):
    global cnt, god_string
    if depth == len(god_string):
        cnt += 1
        return        
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx == -1:
            nx = n-1
        elif nx == n:
            nx = 0
        if ny == -1:
            ny = m-1
        elif ny == m:
            ny = 0 
        if god_string[depth] == hell[nx][ny]:
            dfs(nx,ny,depth + 1)
    
for god_string in god:
    if god_string in cnt_save:
        print(cnt_save[god_string])
    else:
        cnt = 0
        for i in range(n):
            for j in range(m):
                if hell[i][j] == god_string[0]:
                    dfs(i,j,1)
        cnt_save[god_string] = cnt
        print(cnt)