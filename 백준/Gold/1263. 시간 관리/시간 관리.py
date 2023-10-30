from sys import stdin
input = stdin.readline        

n = int(input())
work = [tuple(map(int,input().split())) for _ in range(n)]
work.sort(key= lambda x: x[1])

end = work[-1][1]
for i in range(n-1,-1,-1):
    if work[i][1] <= end:
        end = work[i][1] - work[i][0]
    elif work[i][1] > end:
        end -= work[i][0]

if end >= 0:
    print(end)
else:
    print(-1) 