from sys import stdin
input = stdin.readline

n = int(input())
points = [tuple(map(float,input().split())) for _ in range(n)]
points.append(points[0])

xr = 0
yr = 0
for i in range(n):
    xr += points[i][0] * points[i+1][1]    
    yr += points[i][1] * points[i+1][0]    

print(round(abs(xr - yr)/2,1))