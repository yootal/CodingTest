import sys,math
input = sys.stdin.readline

position = []
for _ in range(4):
    position.append(tuple(map(float,input().split())))
    
def dist(a,b):
    return math.sqrt((b[0]-a[0])**2 + (b[1]-a[1])**2)
    
def solve(arr,d):
    global ans
    if len(arr) == 3:
        ans = min(ans,d)
        return        
    for i in range(1,4):
        if i not in arr:
            if not arr:
                dd = dist(position[0],position[i])
                d += dd
                arr.append(i)
                solve(arr,d)
                d -= dd
                arr.pop()
            
            else:
                dd = dist(position[arr[-1]],position[i])
                d += dd
                arr.append(i)
                solve(arr,d)
                d -= dd
                arr.pop()
            
ans = sys.maxsize
solve([],0)
print(int(ans))
            