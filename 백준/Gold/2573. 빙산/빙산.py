import sys
sys.setrecursionlimit(10**4)
input = sys.stdin.readline

dy,dx = [1,-1,0,0],[0,0,1,-1]

def dfs(r,c):
    visited[r][c] = 1
    for j in range(4):
        ny2 = r + dy[j]
        nx2 = c + dx[j]
        if ny2 < 0 or ny2 > row-1 or nx2 < 0 or nx2 > col-1:
            continue
        if visited[ny2][nx2] == 0 and iceberg[ny2][nx2] != 0:
            dfs(ny2,nx2)
        
row, col = map(int,input().split())

iceberg = []

for _ in range(row):
    iceberg.append(list(map(int,input().split())))

year = 0

while True:
    if year > 0:
        melt_count = []
        for y in range(row):
            for x in range(col):
                if iceberg[y][x] != 0:
                    count = 0
                    for i in range(4):
                        ny = y + dy[i]
                        nx = x + dx[i]
                        if ny < 0 or ny > row-1 or nx < 0 or nx > col-1:
                            continue
                        if iceberg[ny][nx] == 0:
                            count += 1
                    melt_count.append((y,x,count))

        for m in melt_count:
            iceberg[m[0]][m[1]] -= m[2]
            if iceberg[m[0]][m[1]] < 0:
                iceberg[m[0]][m[1]] = 0

    iceberg_count = 0
    visited = [[0] * col for _ in range(row)]              
    for y1 in range(row):
        for x1 in range(col):
            if iceberg[y1][x1] != 0 and visited[y1][x1] == 0:
                dfs(y1,x1)
                iceberg_count += 1
    if iceberg_count >= 2:
        print(year)   
        break
    else:
        if sum(map(sum,iceberg)) == 0:
            print(0)
            break
        year += 1
    

    
    
    
    

        
