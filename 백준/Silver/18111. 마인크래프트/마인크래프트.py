from sys import stdin, maxsize
input = stdin.readline

n,m,b = map(int,input().split())
ground = []

highest = 0
for _ in range(n):
    inp = list(map(int,input().split()))
    for x in inp:
        highest = max(highest,x)
    ground.append(inp)
    
ans_h = 0
ans_t = maxsize

for h in range(highest,-1,-1):
    have = b
    time = 0
    for i in range(n):
        for j in range(m):
            cnt = h - ground[i][j]
            if cnt > 0:
                time += cnt
                have -= cnt    
            elif cnt < 0:
                time -= 2*cnt
                have -= cnt
                
    if time >= ans_t:
        break     
    if have < 0:
        continue

    ans_t = time
    ans_h = h

print(ans_t,ans_h)