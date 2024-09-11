a, b, c = map(int, input().split())

if a + b + c == 1:
    if a == 1:
        print("A")
    elif b == 1:
        print("B")
    else:
        print("C")
elif a + b + c == 2:
    if a == 0:
        print("A")
    elif b == 0:
        print("B")
    else:
        print("C")
else:
    print("*")