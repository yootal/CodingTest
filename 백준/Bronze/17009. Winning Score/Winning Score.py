a = 0
b = 0
for i in range(3, 0, -1):
    a += int(input()) * i
for i in range(3, 0, -1):
    b += int(input()) * i
if a > b:
    print('A')
elif a < b:
    print('B')
else:
    print('T')