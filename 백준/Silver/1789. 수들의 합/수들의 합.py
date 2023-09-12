n = int(input())
total = 0
value = 1
while True:
    total += value
    if total > n:
        print(value-1)
        break
    value += 1