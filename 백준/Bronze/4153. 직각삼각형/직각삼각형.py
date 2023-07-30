import sys
input = sys.stdin.readline

while True:
    length = list(map(int,input().split()))
    
    if length[0] == 0 and length[1] == 0 and length[2] == 0:
        exit()
    else:
        max = 0
        index = 0
        for i in range(3):
            if max < length[i]:
                max = length[i]
                index = i
        check = 0
        for i in range(3):
            if length[i] != max:
                check += (length[i]**2)
        if check == (max**2):
            print("right")
        else:
            print("wrong")
        