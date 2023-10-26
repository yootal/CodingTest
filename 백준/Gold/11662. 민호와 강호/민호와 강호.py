from sys import stdin
input = stdin.readline

def dist(r):
    x1 = ax*r + bx*(1-r)
    y1 = ay*r + by*(1-r)
    x2 = cx*r + dx*(1 - r)
    y2 = cy*r + dy*(1 - r)
    return ((x2 - x1)**2 + (y2 - y1)**2)**0.5

def ternary_search(left,right):
    while abs(right - left) > 1e-9:
        left3 = (2*left + right) / 3
        right3 = (left + 2*right) / 3
        if dist(left3) > dist(right3):
            left = left3
        else:
            right = right3
    return dist(left)

ax,ay,bx,by,cx,cy,dx,dy = map(int,input().split())
ans = ternary_search(0,1)
print(ans)
