from sys import stdin
from collections import deque
input = stdin.readline

def eratosthenes():
    num = [True] * 10000
    num[0],num[1] = False,False
    primes = []
    for i in range(2,100):
        if num[i]:
            for j in range(i**2,10000,i):
                num[j] = False
    for k in range(1000,10000):
        if num[k]:
            primes.append(tuple(map(int,str(k))))
    return primes

def solve(st,en):
    dq = deque()
    vis = set([st])
    dq.append((st[0],st[1],st[2],st[3],0))
    while dq:
        x1,x2,x3,x4,cnt = dq.popleft()
        if (x1,x2,x3,x4) == en:
            print(cnt)
            return
        for j in range(10):    
            if (j,x2,x3,x4) not in vis and (j,x2,x3,x4) in primes:
                vis.add((j,x2,x3,x4))
                dq.append((j,x2,x3,x4,cnt + 1))
            if (x1,j,x3,x4) not in vis and (x1,j,x3,x4) in primes:
                vis.add((x1,j,x3,x4))
                dq.append((x1,j,x3,x4,cnt + 1))
            if (x1,x2,j,x4) not in vis and (x1,x2,j,x4) in primes:
                vis.add((x1,x2,j,x4))
                dq.append((x1,x2,j,x4,cnt + 1))
            if (x1,x2,x3,j) not in vis and (x1,x2,x3,j) in primes:
                vis.add((x1,x2,x3,j))
                dq.append((x1,x2,x3,j,cnt + 1))
    
primes = eratosthenes()
for _ in range(int(input())):
    a,b = input().rstrip().split()
    a = tuple(map(int,a))
    b = tuple(map(int,b))
    solve(a,b)
    