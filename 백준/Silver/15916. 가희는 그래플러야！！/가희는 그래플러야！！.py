from sys import stdin
input = stdin.readline

def ccw(x1,y1,x2,y2,x3,y3):
    result = x1 * y2 + x2 * y3 + x3 * y1 - (y1 * x2 + y2 * x3 + y3 * x1)
    if result > 0:
        return 1
    elif result < 0:
        return -1
    return 0

def check(x1,y1,x2,y2,a1,a2,b1,b2):
    r1 = ccw(x1,y1,x2,y2,a1,a2)
    r2 = ccw(x1,y1,x2,y2,b1,b2)
    r3 = ccw(a1,a2,b1,b2,x1,y1)
    r4 = ccw(a1,a2,b1,b2,x2,y2)
    
    result1 = r1 * r2
    result2 = r3 * r4
    
    if result1 <= 0 and result2 <= 0:
        return True
    return False

n = int(input())
point = [0] + list(map(int,input().split()))
k = int(input())

if point[1] == k:
    print('T')
    exit()

if k == 0:
    for i in range(1,n+1):
        if point[i] == 0:
            print('T')
            exit()
    print('F')
    exit()
    
x = 2**31 // k
y = k * x

for i in range(2,n+1):
    if check(0,0,x,y,i-1,point[i-1],i,point[i]):
        print('T')
        exit()
        
print('F')
