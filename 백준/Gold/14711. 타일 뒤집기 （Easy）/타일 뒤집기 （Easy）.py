from sys import stdin
input = stdin.readline

n = int(input())
s = list(input().rstrip())

graph = ['' for _ in range(n)]
vis = [[0] * n for _ in range(n)]

for i in range(n):
    graph[0] += s[i]
    
for i in range(n):
    for j in range(n):
        if graph[i][j] == '#':
            if j > 0 :
                vis[i][j-1] ^= 1
            if j < n - 1:
                vis[i][j+1] ^= 1
            if i < n - 1:
                vis[i+1][j] ^= 1
    if i + 1 < n:
        for j in range(n):
            if vis[i][j]:
                graph[i+1] += '#'
            else:
                graph[i+1] += '.'
    for j in range(n):
        print(graph[i][j],end="")
    print()  