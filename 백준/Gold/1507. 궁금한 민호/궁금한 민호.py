import sys
input = sys.stdin.readline
inf = sys.maxsize

n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
unit = [[False] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        check = True
        for k in range(n):
            if k == i or k == j:
                continue
            temp = graph[i][k] + graph[k][j]
            if temp < graph[i][j]:
                print(-1)
                exit()
            elif temp == graph[i][j]:
                check = False
        if check:
            unit[i][j] = True
            
ans = 0
for i in range(n):
    for j in range(i+1,n):
        if unit[i][j]:
            ans += graph[i][j]
print(ans)