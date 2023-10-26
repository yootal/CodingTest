from sys import stdin
input = stdin.readline

def ccw(a1,b1,a2,b2,a3,b3):
    check = (a2-a1) * (b3-b1) - (b2-b1) * (a3-a1)
    if check > 0:
        return 1
    elif check < 0:
        return -1
    else:
        return 0
    
x1,y1,x2,y2 = map(int,input().split())
x3,y3,x4,y4 = map(int,input().split())

ans = 0
if ccw(x1,y1,x2,y2,x3,y3) * ccw(x1,y1,x2,y2,x4,y4) < 0 and ccw(x3,y3,x4,y4,x1,y1) * ccw(x3,y3,x4,y4,x2,y2) < 0:
    ans = 1 
print(ans)

