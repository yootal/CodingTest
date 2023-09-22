import sys
input=sys.stdin.readline

a,b,c, = map(int,input().split())

p = a
q = 2*b*c
r = a*(c*c - a*a + b*b)

d = q*q - 4*p*r

if d < 0:
    print(-1)
    exit()
    
x = (-q + (d**0.5)) / (2*p)
if x < 0:
    print(-1)
    exit()
    
print(int(x))
