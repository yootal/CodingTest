def eratosthenes():
    prime = []
    num = [False] * (int(10000000 ** 0.5) + 2)
    for i in range(2, int(10000000 ** 0.5) + 2):
        if not num[i]:
            prime.append(i)
            for j in range(i * i, int(10000000 ** 0.5) + 2, i):
                num[j] = True
    return prime


t = int(input())
ans = []
primes = eratosthenes()
for case in range(1, t + 1):
    a = int(input())
    i = 0
    while a >= primes[i] ** 2:
        if a % (primes[i] ** 2) == 0:
            a //= primes[i] ** 2
        else:
            i += 1
    ans.append(f'#{case} {a}')
for x in ans:
    print(x)
