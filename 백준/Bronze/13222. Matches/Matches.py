import sys
input = sys.stdin.readline

n,w,h = map(int, input().split())
d = int((w**2 + h**2)**0.5)

for _ in range(n):
    inp = int(input())
    if inp <= d:
        print('YES')
    else:
        print('NO')