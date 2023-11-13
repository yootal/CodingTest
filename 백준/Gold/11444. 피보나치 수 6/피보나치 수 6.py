from sys import stdin
from collections import defaultdict
input = stdin.readline
mod = 1000000007
d = defaultdict(int)

def fibo(n):
    if n <= 0:
        return 0 
    elif n == 1:
        return 1
    elif n == 2:
        return 1
    elif n in d:
        return d[n]
    else:
        if n % 2:
            m = (n+1) // 2
            t1 = fibo(m)
            t2 = fibo(m-1)
            d[n] = (t1*t1 + t2*t2) % mod
            return d[n]
        else:
            m = n // 2
            t1 = fibo(m-1)
            t2 = fibo(m)
            d[n] = ((2*t1 + t2) * t2) % mod
            return d[n]  

n = int(input())
print(fibo(n))