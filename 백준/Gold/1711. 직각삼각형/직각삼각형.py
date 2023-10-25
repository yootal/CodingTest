from sys import stdin
input = stdin.readline

n = int(input())
points = [tuple(map(int,input().split())) for _ in range(n)]
ans = 0
for i in range(n-2):
    for j in range(i+1,n-1):
        for k in range(j+1,n):
            p1, p2, p3 = points[i], points[j], points[k]
            d1 = (p1[0]-p2[0])**2 + (p1[1]-p2[1])**2
            d2 = (p2[0]-p3[0])**2 + (p2[1]-p3[1])**2
            d3 = (p3[0]-p1[0])**2 + (p3[1]-p1[1])**2
            if 2*max(d1,d2,d3) == d1+d2+d3:
                ans += 1
print(ans)
    