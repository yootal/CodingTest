import sys
input=sys.stdin.readline
from collections import deque

def rotate(n,dir,to):
    if to == 0:
        if n == 3:
            if wheel[n][6] == wheel[n-1][2]:
                rotate(n-1,0,-1)
            else: 
                rotate(n-1,-dir,-1)
                
        elif n == 0:
            if wheel[n][2] == wheel[n+1][6]:
                rotate(n+1,0,1)
            else:
                rotate(n+1,-dir,1)
        
        else:
            if wheel[n][2] == wheel[n+1][6]:
                rotate(n+1,0,1)
            else:
                rotate(n+1,-dir,1)
    
            if wheel[n][6] == wheel[n-1][2]:
                rotate(n-1,0,-1)
            else: 
                rotate(n-1,-dir,-1)
            
    elif to == 1:
        if n == 3:
            if dir == 1:
                pn = wheel[n].pop()
                wheel[n].appendleft(pn)
            elif dir == -1:
                pn = wheel[n].popleft()
                wheel[n].append(pn) 
            return
        
        if wheel[n][2] == wheel[n+1][6]:
            rotate(n+1,0,1)
        else:
            rotate(n+1,-dir,1)
        
    elif to == -1:
        if n == 0:
            if dir == 1:
                pn = wheel[n].pop()
                wheel[n].appendleft(pn)
            elif dir == -1:
                pn = wheel[n].popleft()
                wheel[n].append(pn) 
            return
        
        if wheel[n][6] == wheel[n-1][2]:
            rotate(n-1,0,-1)
        else: 
            rotate(n-1,-dir,-1)
            
    if dir == 1:
        pn = wheel[n].pop()
        wheel[n].appendleft(pn)
    elif dir == -1:
        pn = wheel[n].popleft()
        wheel[n].append(pn)

wheel = [deque(list(map(int,input().rstrip()))) for _ in range(4)]
k = int(input())
command = [list(map(int,input().split())) for _ in range(k)]

for c in command:
    rotate(c[0]-1,c[1],0)
    
ans = 0
for w in range(4):
    if wheel[w][0] == 0:
        continue
    elif wheel[w][0] == 1:
        if w == 0:
            ans += 1
        elif w == 1:
            ans += 2
        elif w == 2:
            ans += 4
        else:
            ans += 8
print(ans) 