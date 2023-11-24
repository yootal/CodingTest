from sys import stdin
input = stdin.readline

def round2(num):
    return int(num) + 1 if num - int(num) >= 0.5 else int(num)

n = int(input())
if not n:
    print(0)
else:
    level = sorted([int(input()) for _ in range(n)])
    n2 = round2(n * 0.15)
    print(round2(sum(level[n2:-n2] if n2 else level) / (n - (2*n2))))