import sys
input = sys.stdin.readline

n,p,q = map(int,input().split())
dict = {}
dict[0] = 1

def dfs(n):
    if n in dict:
        return dict[n]
    else:
        dict[n] = dfs(n//p) + dfs(n//q)
        return dict[n]
    
print(dfs(n))