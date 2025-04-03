n = input()
level = 0
while len(n) > 1:
    v = 1
    for i in n:
        v *= int(i)
    level += 1
    n = str(v)
print(level)
