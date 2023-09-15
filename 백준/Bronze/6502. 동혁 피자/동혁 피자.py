cnt = 0
while True:
    cnt += 1
    p = list(map(int,input().split()))
    if p[0] == 0:
        break
    d = (p[1]**2 + p[2]**2) ** 0.5
    print(f"Pizza {cnt} fits on the table." if p[0]*2 >= d else f"Pizza {cnt} does not fit on the table.")