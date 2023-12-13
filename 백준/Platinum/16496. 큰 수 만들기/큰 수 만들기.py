from sys import stdin
input = stdin.readline

def check(x):
    idx = len(x) - 1
    value = 0
    x_int = int(x)
    flag = False
    while x_int != 0:
        w = (x_int % 10)
        if w > int(x[0]):
            flag = True
        value += w * (10**-idx)
        x_int //= 10
        idx -= 1
    if flag or len(x) == 1:
        if int(x[0]) < int(x[-1]):
            value += (int(x[-1])) * (10**-len(x))
        else:
            value += (int(x[-1])+1) * (10**-len(x))
    else:
        if int(x[0]) > int(x[-1]):
            value += (int(x[-1])+1) * (10**-len(x))
        else:
            for i in range(len(x),10):
                value += int(x[-1]) * (10**-i)
    return round(value,9)

n = int(input())
num = list(input().rstrip().split())
# for x2 in num:
#     print(check(x2))
num.sort(key=lambda x: (check(x),len(x)),reverse=True)
print(int(''.join(num)))