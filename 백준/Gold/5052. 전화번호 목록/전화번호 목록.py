import sys
input = sys.stdin.readline

def cc(c):
    return ord(c)- ord('0')

def insert(s):
    global unused
    cur = root
    for c in s:
        if nxt[cur][cc(c)] == -1:
            unused += 1
            nxt[cur][cc(c)] = unused
        cur = nxt[cur][cc(c)]
    check[cur] = True
    
def count(s):
    cur = root
    for c in s:
        if nxt[cur][cc(c)] == -1:
            return False
        cur = nxt[cur][cc(c)]
    return True

t = int(input())
for _ in range(t):
    root = 1
    unused = 2
    mx = 10000 * 10 # 최대 등장 가능
    check = [False] * mx
    nxt = [[-1] * 10 for _ in range(mx)]     
    l = []         

    n = int(input())
    for _ in range(n):
        inp = input().rstrip()
        l.append(inp)
    
    l.sort(key = lambda x: (len(x),x), reverse=True)
    
    ans = 0
    flag = True   
    insert(l[0])
    for i in range(1,n):
        if count(l[i]):
            flag = False
            break
        else:
            insert(l[i])

    if flag:
        print("YES")
    else:
        print("NO")