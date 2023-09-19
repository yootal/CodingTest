import sys 
from math import pi
input = sys.stdin.readline

a,p1 = map(int,input().split())
b,p2 = map(int,input().split())

if p1/a < p2/(b**2*pi):
    print("Slice of pizza")
else:
    print("Whole pizza")