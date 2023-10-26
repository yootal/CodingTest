from sys import stdin
from math import sqrt
input = stdin.readline

def check(p):
    for i in range(8):
        if (p[i] * p[(i + 2) % 8] * sqrt(2) > p[(i + 1) % 8] * (p[i] + p[(i + 2) % 8])):
            return False
    return True
    
def dfs(d,arr):
    global ans
    if d == 8:
        if check(arr):
            ans += 1
        return
    for i in range(8):
        if not vis[i]:
            vis[i] = True
            dfs(d+1,arr + [stat[i]])
            vis[i] = False    

stat = list(map(int,input().split()))
vis = [False] * 8

ans = 0
dfs(0,[])
print(ans)