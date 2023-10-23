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

mod = 1234567891
t = int(input())
for case in range(1,t+1):
    n,r = map(int,input().split())
    top = factorial(n)
    bottom = factorial(n-r) * factorial(r) % mod
    ans = top * mod_division(bottom,mod-2) % mod
    print(f"#{case} {ans}")