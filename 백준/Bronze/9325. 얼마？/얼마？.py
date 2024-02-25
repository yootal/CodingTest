for _ in range(int(input())):
    price = int(input())
    for _ in range(int(input())):
        q,p = map(int,input().split())
        price += q * p
    print(price)