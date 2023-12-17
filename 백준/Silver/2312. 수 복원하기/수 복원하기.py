from sys import stdin
from collections import defaultdict
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

limit = 100000
primes = eratosthenes()
for _ in range(int(input())):
    n = int(input())
    idx = 0
    cnt = defaultdict(int)
    while True:
        if n % primes[idx] == 0:
            cnt[primes[idx]] += 1
            n //= primes[idx]
            if n == 1:
                break
        else:
            idx += 1
    for k,v in cnt.items():
        print(k,v)