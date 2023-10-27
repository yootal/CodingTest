from sys import stdin
from math import pi
input = stdin.readline

while True:
    try:
        x1,y1,x2,y2,x3,y3 = map(float,input().split())
    except:
        break

    b = ((x2**2 - x1**2 + y2**2 - y1**2) * (2 * x1 - 2 * x3) - (x3**2 - x1**2 + y3**2 - y1**2) * (2 * x1 - 2 * x2)) / ((2 * y1 - 2 * y2) * (2 * x1 - 2 * x3) - (2 * y1 - 2 * y3) * (2 * x1 - 2 * x2))
    try:
        a = (x2**2 - x1**2 + y2**2 - y1**2 - (2 * y1 - 2 * y2) * b) / (2 * x1 - 2 * x2)
    except:
        a = (x3**2 - x1**2 + y3**2 - y1**2 - (2 * y1 - 2 * y3) * b) / (2 * x1 - 2 * x3)
    r = ((x1 + a)**2 + (y1 + b)**2)**0.5

    print(round(2*r*pi,2))