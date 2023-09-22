import sys
input=sys.stdin.readline

def dist(p1,p2):
    return ((p1[0] - p2[0])**2 + (p1[1] - p2[1])**2)**0.5

for _ in range(int(input())):
    tmp = 0
    points = []
    for _ in range(4):
        x,y = map(int,input().split())
        points.append((x,y))
    points.sort()
    
    for x,y in points:
        if (x,y) == (0,0):
            tmp += 1
    if tmp == 4:
        print(0)
    elif dist(points[0],points[1]) == dist(points[0],points[2]) == dist(points[1],points[3]) and dist(points[1],points[2]) == dist(points[0],points[3]):
        print(1)
    else:
        print(0)