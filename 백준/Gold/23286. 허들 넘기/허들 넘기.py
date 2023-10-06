from sys import stdin, maxsize
input = stdin.readline

def floyd():
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                temp = max(graph[i][k],graph[k][j])
                if graph[i][j] > temp:
                    graph[i][j] = temp

n,m,t = map(int,input().split())
graph = [[maxsize] * (n+1) for _ in range(n+1)]
for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a][b] = c
    
floyd()
    
for _ in range(t):
    s,e = map(int,input().split())
    print(graph[s][e] if graph[s][e] != maxsize else -1)