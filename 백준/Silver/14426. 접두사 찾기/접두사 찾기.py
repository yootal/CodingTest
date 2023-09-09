import sys
input = sys.stdin.readline

root = 1
unused = 2
mx = 10000 * 500 # 최대 등장 가능
check = [False] * mx
nxt = [[-1] * 26 for _ in range(mx)]

def cc(c):
    return ord(c)- ord('a')

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

n,m = map(int,input().split())
for _ in range(n):
    inp = input().rstrip()
    insert(inp)

ans = 0
for _ in range(m):
    inp = input().rstrip()
    if count(inp):
        ans += 1

print(ans)