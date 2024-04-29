_a = list(map(int, input().split()))
_b = list(map(int, input().split()))
a = _a[0] * 3 + _a[1] * 20 + _a[2] * 120
b = _b[0] * 3 + _b[1] * 20 + _b[2] * 120
if a == b:
    print("Draw")
elif a > b:
    print("Max")
else:
    print("Mel")