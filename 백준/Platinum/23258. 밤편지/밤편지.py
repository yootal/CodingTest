from sys import stdin, maxsize
input = stdin.readline

def floyd():
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                if i == j or j == k or k == i:
                    graph[k][i][j] = graph[k-1][i][j]
                else:
                    graph[k][i][j] = min(graph[k-1][i][j],graph[k-1][i][k] + graph[k-1][k][j])
                
n,q = map(int,input().split())
graph = [[[maxsize] * (n+1) for _ in range(n+1)] for _ in range(n+1)]
for i in range(n):
    inp = list(map(int,input().split()))
    for j in range(n):
        if i == j:
            graph[0][i+1][j+1] = 0
            continue
        if inp[j] == 0:
            continue
        graph[0][i+1][j+1] = inp[j]

floyd()

for _ in range(q):
    c,s,e = map(int,input().split())
    print(graph[c-1][s][e] if graph[c-1][s][e] != maxsize else -1)   