from sys import stdin
from itertools import combinations
input = stdin.readline

def area(x,y,z):
    return abs((x[0]*y[1]+y[0]*z[1]+z[0]*x[1]-x[1]*y[0]-y[1]*z[0]-z[1]*x[0]))/2

n = int(input())
points = [tuple(map(float,input().split())) for _ in range(n)]
area_list = []
point_list = list(combinations(points,3))
for p in point_list:
    area_list.append(area(p[0],p[1],p[2]))
print(max(area_list))