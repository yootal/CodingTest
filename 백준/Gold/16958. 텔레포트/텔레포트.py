from sys import stdin, maxsize
input = stdin.readline

def calc_dist(p1,p2):
    return abs(p1[0]-p2[0]) + abs(p1[1]-p2[1])

n,t = map(int,input().split())
city = []
position = []
dist = [[maxsize] * n for _ in range(n)]

for _ in range(n):
    s,x,y = map(int,input().split())
    city.append(s)
    position.append((x,y))
    
for i in range(n):
    dist[i][i] = 0
    for j in range(i+1,n):
        d = calc_dist(position[i],position[j])
        if city[i] == 1 and city[j] == 1:
            d = min(t,d)
            dist[i][j] = d
            dist[j][i] = d
            continue
        dist[i][j] = d
        dist[j][i] = d

for k in range(n):
    for i in range(n):
        for j in range(n):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]    
                
m = int(input())
for _ in range(m):
    a,b = map(int,input().split())    
    print(dist[a-1][b-1])