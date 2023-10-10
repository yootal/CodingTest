def eratosthenes():
    num = [True] * 10001
    for i in range(2,10001):
        if num[i]:
            for j in range(i*i,10001,i):
                num[j] = False
    return num
    
prime = eratosthenes()
for _ in range(int(input())):
    n = int(input())
    mid = n // 2
    while True:
        if prime[mid] and prime[n - mid]:
            print(mid,n-mid)
            break
        else:
            mid -= 1