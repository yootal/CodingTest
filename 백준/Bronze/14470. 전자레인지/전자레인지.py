a = int(input())
b = int(input())
c = int(input())
d = int(input())
e = int(input())
time = 0
temp = 0
if a <= 0:
    time += (-a) * c
    time += d
else:
    temp = a
time += (b - temp) * e
print(time)