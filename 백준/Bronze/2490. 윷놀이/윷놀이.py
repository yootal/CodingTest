for _ in range(3):
    num = list(map(int,input().split()))
    cnt = num.count(1)
    if cnt == 0:
        print("D")
    elif cnt == 1:
        print("C")
    elif cnt == 2:
        print("B")
    elif cnt == 3:
        print("A")
    else:
        print("E")        
    