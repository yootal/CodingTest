import sys
input = sys.stdin.readline

def eratosthenes(limit):
    prime_flags = [True] * (limit + 1)
    prime_flags[0] = prime_flags[1] = False

    for num in range(2, int(limit**0.5) + 1):
        if prime_flags[num]:
            for multiple in range(num * num, limit + 1, num):
                prime_flags[multiple] = False

    prime_list = [num for num, is_prime in enumerate(prime_flags) if is_prime]
    return prime_list
    
n = int(input())
if n == 1:
    print(0)
else:
    prime = eratosthenes(n)
    prime_len = len(prime)
    ans = 0
    en = 0
    total = prime[0]
    for st in range(prime_len):
        if st > 0:
            total -= prime[st - 1]
        while en < prime_len - 1 and total < n:
            en += 1 
            total += prime[en]
        if total == n:
            ans += 1
        if st == prime_len - 1:
            break
    print(ans)
    