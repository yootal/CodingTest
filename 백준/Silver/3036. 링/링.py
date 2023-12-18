from sys import stdin
from math import gcd
input = stdin.readline

n = int(input())
radius = list(map(int,input().split()))
for i in range(1,n):
    _gcd = gcd(radius[0],radius[i])
    print(f'{radius[0]//_gcd}/{radius[i]//_gcd}')