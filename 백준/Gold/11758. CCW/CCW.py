import sys
input = sys.stdin.readline

def ccw(a,b,c):
    return (a[0]*b[1] + b[0]*c[1] + c[0]*a[1] - (b[0]*a[1] + c[0]*b[1] + a[0]*c[1]))

points = []
for _ in range(3):
    points.append(tuple(map(int,input().split())))

result = ccw(points[0],points[1],points[2])

if result > 0:
    print(1)
elif result == 0:
    print(0)
else:
    print(-1)