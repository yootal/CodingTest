from sys import stdin
input = stdin.readline

def solve(cur,cnt):
    global ans
    
    idx = set()
    for i in range(len(pair)):
        if vis[i]:
            idx.add(pair[i][0])
            idx.add(pair[i][1])
    
    if cnt > 0:
        ex = ''
        for i in range(len(s)):
            if i in idx:
                continue
            ex += s[i]
        ans.append(ex)
            
    for i in range(cur,len(pair)):
        if not vis[i]:
            vis[i] = True
            solve(i+1,cnt+1)
            vis[i] = False

s = list(input().rstrip())
pair = []
stack = []
for i in range(len(s)):
    if s[i] == '(':
        stack.append(i)
    elif s[i] == ')':
        pair.append((stack.pop(),i))

vis = [False] * len(pair)
ans = []
solve(0,0)
for x in sorted(set(ans)):
    print(x)