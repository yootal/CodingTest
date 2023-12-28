from collections import defaultdict

def cnt(x):
    if dp[x]:
        return dp[x]
    else:
        if len(child[x]) == 0:
            dp[x] = 1
        else:
            total = 0
            for nxt in child[x]:
                total += cnt(nxt)
            dp[x] = total + 1
        return dp[x]
    
def search_parent(x):
    if not check[x]:
        check[x] = 1
        return search_parent(parent[x])
    else:
        return x

t = int(input())
for case in range(1, t + 1):
    v,e,p1,p2 = map(int,input().split())
    info = list(map(int,input().split()))
    child = defaultdict(list)
    parent = defaultdict(int)
    check = [0] * (v+1)
    dp = [0] * (v+1)
    for i in range(0,len(info),2):
        p = info[i]
        c = info[i+1]
        child[p].append(c)
        parent[c] = p
    search_parent(p1)
    ans_p = search_parent(p2)
    ans_cnt = cnt(ans_p)
    print(f'#{case} {ans_p} {ans_cnt}')
            