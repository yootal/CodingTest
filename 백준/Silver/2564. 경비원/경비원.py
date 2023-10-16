from sys import stdin
input = stdin.readline

def dist(x,y):
    if x == 1:
        return y
    if x == 2:
        return w + h + w - y
    if x == 3:
        return w + h + w + h - y
    if x == 4:
        return w + y

w,h = map(int,input().split())
n = int(input())

points = []
for _ in range(n+1):
    x,y = map(int,input().split())
    points.append(dist(x,y))

ans = 0
for i in range(n):
    p1 = abs(points[-1] - points[i])
    p2 = 2 * (w+h) - p1
    ans += min(p1,p2)

print(ans)
        