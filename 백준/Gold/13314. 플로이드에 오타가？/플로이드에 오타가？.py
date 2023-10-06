from sys import stdin, maxsize
input = stdin.readline

n = 100
dist = [[0] * (n+1) for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,n+1):
        dist[i][j] = 10000
        if i == n or j == n:
            dist[i][j] = 4999
        if i == j:
            dist[i][j] = 0
            
print(n)
for i in range(1,n+1):
    for j in range(1,n+1):
        print(dist[i][j],end=" ")
    print()