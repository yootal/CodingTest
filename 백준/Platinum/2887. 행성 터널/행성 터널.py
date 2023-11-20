import sys
input = sys.stdin.readline

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
planet_x = []
planet_y = []
planet_z = []

for i in range(1,n+1):
    x,y,z = map(int,input().split())
    planet_x.append((x,i))
    planet_y.append((y,i))
    planet_z.append((z,i))

planet_x.sort()
planet_y.sort()
planet_z.sort()

planet_dist = []
for i in range(1,n):
    planet_dist.append((abs(planet_x[i-1][0]-planet_x[i][0]),planet_x[i-1][1],planet_x[i][1]))
    planet_dist.append((abs(planet_y[i-1][0]-planet_y[i][0]),planet_y[i-1][1],planet_y[i][1]))
    planet_dist.append((abs(planet_z[i-1][0]-planet_z[i][0]),planet_z[i-1][1],planet_z[i][1]))
planet_dist.sort()

ans = 0
for cost,a,b in planet_dist:
    if not union(a,b):
        continue
    ans += cost

print(ans)