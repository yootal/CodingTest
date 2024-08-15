import math

a, i = map(int, input().split())
x = 1
while True:
    if i == math.ceil(x / a):
        print(x)
        break
    x += 1