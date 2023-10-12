from sys import stdin
input = stdin.readline

while True:
    try:
        n = int(input())
    except:
        break
    i = 1
    while True:
        num = int('1' * i)
        if num % n == 0:
            print(i)
            break
        i += 1
    