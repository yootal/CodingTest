import sys
input = sys.stdin.readline

for _ in range(int(input())):
    x1,y1,r1,x2,y2,r2 = map(int,input().split())
    dist = ((x1-x2)**2 + (y1-y2)**2) ** 0.5
    if dist == 0 and r1 == r2: # 두 원이 동심원이고 반지름이 같음
        print(-1)
    elif abs(r1-r2) == dist or r1 + r2 == dist: # 내접 or 외접
        print(1)
    elif abs(r1-r2) < dist < (r1+r2): # 두 원이 서로 다른 두점에서 만남
        print(2)
    else:
        print(0)