from itertools import permutations

def dist(x,y):
    return abs(x[0]-y[0]) + abs(x[1]-y[1])

t = int(input())
for case in range(1, t + 1):
    n = int(input())
    info = list(map(int,input().split()))
    points = []
    for i in range(0,len(info),2):
        points.append((info[i],info[i+1]))
    ans = int(1e9)
    st = points[0]
    en = points[1]
    for per in permutations(points[2:]):
        ans = min(ans,dist(st,per[0]) + dist(per[-1],en) + sum([dist(per[i],per[i+1]) for i in range(n-1)]))
    print(f'#{case} {ans}')    