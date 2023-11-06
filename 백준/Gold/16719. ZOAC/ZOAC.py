from sys import stdin
input = stdin.readline

s = input().rstrip()
n = len(s)
vis = [False] * n

def find(check,idx,arr):
    if check:
        t = ''
        for i in range(n):
            if vis[i]:
                t += s[i]
        arr.append((t,idx))
        return
    for i in range(n):
        if not vis[i]:
            vis[i] = True
            find(True,i,arr)
            vis[i] = False

def solve(cur):
    arr = []
    find(False,-1,arr)
    ans,idx = min(arr)
    print(ans)
    vis[idx] = True
    if cur == n-1:
        return
    solve(cur + 1)

solve(0)    