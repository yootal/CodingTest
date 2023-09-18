import sys
input = sys.stdin.readline

w,h,x,y,p = map(int,input().split())
cnt = 0
for _ in range(p):
    x2,y2 = map(int,input().split())
    
    if x <= x2 <= x+w and y <= y2 <= y+h:
        cnt += 1
        continue
    
    r = h / 2
    dist1 = ((x2-x)**2 + (y2-(y+r))**2)**0.5
    dist2 = ((x2-(x+w))**2 + (y2-(y+r))**2)**0.5
    
    if dist1 <= r or dist2 <= r:
        cnt += 1
        
print(cnt)