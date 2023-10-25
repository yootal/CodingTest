from sys import stdin, maxsize
input = stdin.readline

ax,ay,az,bx,by,bz,cx,cy,cz = map(float,input().split())
ans = maxsize
while True:
    mx,my,mz = (ax+bx)/2,(ay+by)/2,(az+bz)/2
    ac = ((ax-cx)**2+(ay-cy)**2+(az-cz)**2)**0.5
    bc = ((bx-cx)**2+(by-cy)**2+(bz-cz)**2)**0.5
    mc = ((mx-cx)**2+(my-cy)**2+(mz-cz)**2)**0.5
    if abs(ans-mc) <= 1e-6:
        print(ans)
        break
    if mc < ans:
        ans = mc
    if ac > bc:
        ax,ay,az = mx,my,mz
    else:
        bx,by,bz = mx,my,mz