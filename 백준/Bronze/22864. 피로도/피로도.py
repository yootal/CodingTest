import sys
input=sys.stdin.readline

a,b,c,m = map(int,input().split())
fatigue = 0
work = 0

if a > m:
    print(0)
else:
    day = 0
    while day < 24:
        if fatigue + a <= m:
            work += b
            fatigue += a
        else:
            if fatigue - c > 0:
                fatigue -= c
            else:
                fatigue = 0
        day += 1       
    print(work)