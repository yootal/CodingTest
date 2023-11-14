a, b = map(int, input().split())
if a == 1 and b == 3:
    print('A')
elif b == 1 and a == 3:
    print('B')
elif a < b:
    print('B')
else:
    print('A')