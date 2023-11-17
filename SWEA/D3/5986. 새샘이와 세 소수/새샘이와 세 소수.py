def eratosthenes():
    prime = []
    num = [False] * 1000
    for i in range(2, 1000):
        if not num[i]:
            prime.append(i)
            for j in range(i * i, 1000, i):
                num[j] = True
    return prime


t = int(input())
primes = eratosthenes()
pl = len(primes)
for case in range(1, t + 1):
    n = int(input())
    ans = 0
    for i2 in range(pl):
        if primes[i2] * 3 > n:
            break
        for j2 in range(i2, pl):
            if primes[i2] + primes[j2] * 2 > n:
                break
            for k in range(j2, pl):
                _sum = primes[i2] + primes[j2] + primes[k]
                if _sum > n:
                    break
                if _sum == n:
                    ans += 1
    print(f'#{case} {ans}')
