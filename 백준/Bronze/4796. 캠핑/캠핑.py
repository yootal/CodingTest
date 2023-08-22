import sys
input = sys.stdin.readline

case = 0
while True:
    case += 1
    l,p,v = map(int,input().split())
    if (l, p, v) == (0, 0, 0):
        break
    x = v // p
    r = v % p
    if l < r:
        r = l
    print(f"Case {case}: {x * l + r}")