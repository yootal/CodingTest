from sys import stdin
input = stdin.readline

n,m = map(int,input().split())
if n == 1:
    print(1)
elif n == 2:
    if (m+1) // 2 > 4:
        print(4)
    else:
        print((m+1)//2)
else:
    if 1 <= m <=3:
        print(m)
    elif 4 <= m <= 6:
        print(4)
    elif m == 7:
        print(5)
    else:
        print(5 + m - 7)