for _ in range(int(input())):
    h,w,n = map(int,input().split())
    room = n // h + 1
    floor = n % h
    if not floor:
        floor = h
        room -= 1
    print(floor * 100 + room)