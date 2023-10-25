import math
ans = []
t = int(input())
for case in range(1,t+1):
    n = int(input())
    score = 0
    for _ in range(n):
        x,y = map(int,input().split())
        r = math.ceil(math.sqrt(x*x + y*y)/20)
        if r== 0:
            score += 10
        elif r <= 11:
            score += (11-r)
    ans.append(f"#{case} {score}")  
for a in ans:
    print(a)