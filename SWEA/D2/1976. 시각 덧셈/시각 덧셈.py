t  = int(input())
for case in range(1,t+1):
    a1,a2,b1,b2 = map(int,input().split())
    h = a1 + b1
    m = a2 + b2
    if m >= 60:
        m -= 60
        h += 1
    if h > 12:
        h -= 12
    print(f"#{case} {h} {m}")