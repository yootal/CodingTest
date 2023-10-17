from sys import stdin
input = stdin.readline

n = int(input())
num = list(map(int,input().split()))
limit = sum(num)

def back_tracking(cur,total):
    check[total] = True
    for i in range(cur+1,n):
        if not vis[i]:
            vis[i] = True
            back_tracking(i,total + num[i])
            vis[i] = False

check = [False] * (limit+2)
vis =  [False] * n

for x in range(n):
    if not vis[x]:
        vis[x] = True
        back_tracking(x,num[x])
        vis[x] = False
    
for i in range(1,limit+2):
    if not check[i]:
        print(i)
        break
