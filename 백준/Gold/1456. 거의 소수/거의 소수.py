from sys import stdin
input = stdin.readline

def eratosthenes():
    num = [True] * (limit+1)
    num[0],num[1] = False,False
    primes = []
    for i in range(2,limit+1):
        if num[i]:
            primes.append(i)
            for j in range(i**2,limit+1,i):
                num[j] = False
    return primes

limit = 10 ** 7
primes = eratosthenes()
a,b = map(int,input().split())
ans = 0
for p in primes:
    i = p
    while i <= b // p:
        ans += (i*p >= a)
        i *= p
print(ans)