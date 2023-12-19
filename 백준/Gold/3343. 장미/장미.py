from sys import stdin, maxsize
from math import lcm
input = stdin.readline

n,a,b,c,d = map(int,input().split())
ans = maxsize

# a,b를 더 비싼 것으로
if a * d > b * c:
    a,b,c,d = c,d,a,b
    
_lcm = lcm(a,c)

# 비싼걸 최소공배수 / a 이상 사는 경우는 c를 통해 더 싸게 구매할 수 있음
for i in range(_lcm//a):
    cost = i * b
    if n - i * a > 0:
        cost += (((n - i * a - 1) // c) + 1) * d
    ans = min(ans,cost)
print(ans)
        