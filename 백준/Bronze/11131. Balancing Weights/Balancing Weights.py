for i in range(int(input())):
    n = int(input())
    total = sum(list(map(int, input().split())))
    if total > 0:
        print("Right")
    elif total < 0:
        print("Left")
    else:
        print("Equilibrium")
