from sys import stdin
input = stdin.readline

h,v = map(float,input().split())

d = (h**2 + v**2)**0.5

a = v * (h/(h+d))
b = v * (d/(h+d))
c = (a**2 + h**2)**0.5

w = c / 2
k = (b*h) / c

print(round(w,2),round(k,2))