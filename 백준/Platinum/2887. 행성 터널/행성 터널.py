import sys
input = sys.stdin.readline

def calc_dist(a,b):
    return min(abs(a[0]-b[0]),abs(a[1]-b[1]),abs(a[2]-b[2]))

def find(x):
    if p[x] != x:
        p[x] = find(p[x])
    return p[x]

def union(a,b):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    if a < b:
        p[b] = a
    else:
        p[a] = b
    return True
    
n = int(input())
p = list(range(n+1))

planet = []
for i in range(1,n+1):
    planet.append(list(map(int,input().split()))+[i])

planet_x = sorted(planet,key = lambda x: x[0])
planet_y = sorted(planet,key = lambda x: x[1])
planet_z = sorted(planet,key = lambda x: x[2])

planet_dist = []
for i in range(1,n):
    planet_dist.append((calc_dist(planet_x[i-1],planet_x[i]),planet_x[i-1][3],planet_x[i][3]))
    planet_dist.append((calc_dist(planet_y[i-1],planet_y[i]),planet_y[i-1][3],planet_y[i][3]))
    planet_dist.append((calc_dist(planet_z[i-1],planet_z[i]),planet_z[i-1][3],planet_z[i][3]))
planet_dist.sort()

ans = 0
for cost,a,b in planet_dist:
    if not union(a,b):
        continue
    ans += cost

print(ans)
        