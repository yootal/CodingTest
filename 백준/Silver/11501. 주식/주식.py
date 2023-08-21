import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    day = list(map(int,input().split()))
    value = 0
    max = 0
    for i in range(len(day)-1,-1,-1):
        if day[i] > max:
            max = day[i]
        else:
            value += max - day[i]
    print(value)