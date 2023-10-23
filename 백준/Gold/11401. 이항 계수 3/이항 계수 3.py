from sys import stdin
input = stdin.readline

def factorial(num):
    n = 1
    for i in range(2,num+1):
        n = (n * i) % mod
    return n

def mod_division(n,k):
    if k == 0:
        return 1
    elif k == 1:
        return n
    tmp = mod_division(n,k//2)
    if k % 2 == 1:
        return tmp * tmp * n % mod
    else:
        return tmp * tmp % mod

n,k = map(int, input().split())
mod = 1000000007
top = factorial(n)
bottom = factorial(n-k) * factorial(k) % mod
print(top * mod_division(bottom,mod-2) % mod)