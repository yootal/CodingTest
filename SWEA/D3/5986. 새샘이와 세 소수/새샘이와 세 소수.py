def eratosthenes():
    primes = []
    num = [False] * 1001
    for i in range(2, 1001):
        if not num[i]:
            primes.append(i)
            for j in range(i * i, 1001, i):
                num[j] = True
    return primes


t = int(input())
prime_list = eratosthenes()
for case in range(1, t + 1):
    n = int(input())
    ans = 0
    for i in range(len(prime_list)):
        if prime_list[i] * 3 > n:
            break
        for j in range(i, len(prime_list)):
            if prime_list[i] + prime_list[j] * 2 > n:
                break
            for k in range(j, len(prime_list)):
                if prime_list[i] + prime_list[j] + prime_list[k] > n:
                    break
                if prime_list[i] + prime_list[j] + prime_list[k] == n:
                    ans += 1
    print(f'#{case} {ans}')