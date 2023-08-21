import sys
input = sys.stdin.readline

n,m,l = map(int,input().split())
rest = [0,l]
rest.extend(list(map(int,input().split())))
rest.sort()

start, end = 1, l-1
result = 0
while start <= end:
    count = 0
    mid = (start + end) // 2
    for i in range(1, len(rest)):
        if rest[i] - rest[i-1] > mid:
            count += (rest[i] - rest[i-1] - 1) // mid
    if count > m:
        start = mid + 1
    else: 
        end = mid - 1
        result = mid
        
print(result)     