from sys import stdin
input = stdin.readline

n,a,b = map(int,input().split())

ans = 1
while True:
    a2 = a // 2
    if a % 2:
        a2 += 1
    b2 = b // 2
    if b % 2:
        b2 += 1
    if a2 == b2:
        print(ans)
        break
    ans += 1
    a,b = a2,b2
    