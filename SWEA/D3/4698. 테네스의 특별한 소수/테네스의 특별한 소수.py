def eratosthenes():
    primes = []
    num = [False] * (b + 1)
    for i in range(2, b + 1):
        if not num[i]:
            if i >= a:
                primes.append(i)
            for j in range(i * i, b + 1, i):
                num[j] = True
    return primes


t = int(input())
for case in range(1, t + 1):
    d, a, b = map(int, input().split())
    prime_list = eratosthenes()
    ans = 0
    for x in prime_list:
        if str(d) in list(str(x)):
            ans += 1
    print(f'#{case} {ans}')