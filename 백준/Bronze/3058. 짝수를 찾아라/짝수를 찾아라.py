for _ in range(int(input())):
    num=list(map(int,input().split()))
    _min=100
    total=0
    for n in num:
        if n%2==0:
           _min=min(_min,n) 
           total+=n
    print(f'{total} {_min}')