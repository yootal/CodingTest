import sys
from collections import defaultdict
input = sys.stdin.readline

root = 1
unused = 2
mx = 100000 * 10 # 최대 등장 가능
check = [False] * mx
nxt = [defaultdict(int) for _ in range(mx)]
name_cnt = defaultdict(int)

def insert(s):
    global unused
    cur = root
    prefix = ""
    flag = True
    for c in s:
        if flag:
            prefix += c
        if not nxt[cur][c]:
            if flag:
                print(prefix)
                flag = False
            nxt[cur][c] = unused
            unused += 1
        cur = nxt[cur][c]
    if not check[cur]:
        name_cnt[s] += 1
        if flag:
            print(s)
        check[cur] = True
    else:
        name_cnt[s] += 1
        print(f"{s}{name_cnt[s]}")

n = int(input())
for _ in range(n):
    inp = input().rstrip()
    insert(inp)
