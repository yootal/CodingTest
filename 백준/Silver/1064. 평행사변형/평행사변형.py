import sys 
input = sys.stdin.readline

x1,y1,x2,y2,x3,y3 = map(int,input().split())

if (x1-x2) * (y1-y3) == (y1-y2) * (x1-x3):
    print(-1)

else:
    len1 = ((x1-x2)**2 + (y1-y2)**2)**0.5
    len2 = ((x1-x3)**2 + (y1-y3)**2)**0.5
    len3 = ((x2-x3)**2 + (y2-y3)**2)**0.5
    
    len = [len1 + len2, len2 + len3, len3 + len1]
    
    print(2*(max(len) - min(len)))