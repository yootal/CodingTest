from sys import stdin, maxsize
input = stdin.readline

def floyd():
    for k, value in sorted(enumerate(dog),key=lambda x: x[1]):
        if k == 0:
            continue
        dist_graph[k][k] = 0
        bully_graph[k][k] = value
        for i in range(1,n+1):
            for j in range(1,n+1):
                bully = max(bully_graph[i][k], bully_graph[k][j])
                if dist_graph[i][j] + bully_graph[i][j] > dist_graph[i][k] + dist_graph[k][j] + bully:
                    dist_graph[i][j] = dist_graph[i][k] + dist_graph[k][j]
                    bully_graph[i][j] = bully
                
n,m,q = map(int,input().split())
dog = [0] + list(map(int,input().split()))
dist_graph = [[maxsize] * (n+1) for _ in range(n+1)]
bully_graph = [[0] * (n+1) for _ in range(n+1)]
for i in range(m):
    a,b,c = map(int,input().split())
    bully = max(dog[a],dog[b])
    dist_graph[a][b] = dist_graph[b][a] = c
    bully_graph[a][b] = bully_graph[b][a] = bully
    
floyd()

for _ in range(q):
    s,e = map(int,input().split())
    if dist_graph[s][e] == maxsize:
        print(-1)
    else:
        print(dist_graph[s][e] + bully_graph[s][e])