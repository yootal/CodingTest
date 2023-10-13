from sys import stdin, maxsize
input = stdin.readline

n = int(input())
material = [tuple(map(int,input().split())) for _ in range(n)]

def bt(s,b,cur):
    global ans
    ans = min(ans,abs(s-b))
    for i in range(cur+1,n):
        if not vis[i]:
            vis[i] = True
            bt(s*material[i][0],b+material[i][1],i)
            vis[i] = False
    
ans = maxsize
vis = [False] * n
for i in range(n):
    vis[i] = True
    bt(material[i][0],material[i][1],i)
    vis[i] = False

print(ans)