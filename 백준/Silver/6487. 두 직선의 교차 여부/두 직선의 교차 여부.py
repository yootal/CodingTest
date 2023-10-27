from sys import stdin
input = stdin.readline

n = int(input())
for _ in range(n):
    x1,y1,x2,y2,x3,y3,x4,y4 = map(float,input().split())
    
    a = x2-x1
    b = y2-y1
    c = x4-x3
    d = y4-y3
    
    if a*d - b*c:
        r = (d*(x3-x1) - c*(y3-y1)) / (a*d - b*c)
        print(f'POINT {a*r + x1:.2f} {b*r + y1:.2f}')
    else:
        if ((x3-x1) * b - (y3-y1) * a):
            print('NONE')
        else:
            print('LINE')