from sys import stdin
from math import lcm
input = stdin.readline

for _ in range(int(input())):
    a,b = map(int,input().split())
    print(lcm(a,b))
