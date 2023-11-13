from sys import stdin, maxsize
input = stdin.readline

def bellman_ford(st):
    dist = [maxsize] * (n+1)
    dist[st] = 0
    for i in range(n):
        for j in range(2*m+w):
            cur = edge[j][0]
            nxt = edge[j][1]
            cost = edge[j][2]
            if dist[nxt] > dist[cur] + cost:
                dist[nxt] = dist[cur] + cost
                if i == n - 1:
                    return True
    return False
                
for _ in range(int(input())):
    n,m,w = map(int,input().split())
    edge = []
    for _ in range(m):
        s,e,t = map(int,input().split())
        edge.append((s,e,t))
        edge.append((e,s,t))
    for _ in range(w):
        s,e,t = map(int,input().split())
        edge.append((s,e,-t))
    if bellman_ford(1):
        print('YES')
    else:
        print('NO')
    