d = 0
for _ in range(10):
    cmd = int(input())
    if cmd == 1:
        d += 1
        d %= 4
    elif cmd == 2:
        d += 2
        d %= 4
    else:
        d -= 1
        d += 4
        d %= 4
if d == 0:
    print("N")
elif d == 1:
    print("E")
elif d == 2:
    print("S")
else:
    print("W")