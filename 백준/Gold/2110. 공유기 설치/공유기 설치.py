import sys
input=sys.stdin.readline

n,c = map(int,input().split())
points = []
for _ in range(n):
    points.append(int(input()))
    
points.sort()
start = 1
end = points[-1] - points[0]

while start <= end:
    mid = (start+end)//2
    current = points[0]
    count = 1
    
    for i in range(1,len(points)):
        if points[i] >= current + mid:
            count += 1
            current = points[i]
    
    if count >= c:
        global answer
        start = mid + 1
        answer = mid
    else: end = mid - 1

print(answer)