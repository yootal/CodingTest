from collections import defaultdict

def find(x):
    if dp[x]:
        return dp[x]
    else:
        total = 0
        for nxt in child[x]:
            total += find(nxt)
        dp[x] = total
        return dp[x]

def cnt(x):
    if cnt_dp[x]:
        return cnt_dp[x]
    else:
        if len(child[x]) == 0:
            cnt_dp[x] = 1
        else:
            total = 0
            for nxt in child[x]:
                total += cnt(nxt)
            cnt_dp[x] = total + 1
        return cnt_dp[x]
    
def search_parent(x):
    if find(x) != 2:
        return search_parent(parent[x])
    else:
        return x

t = int(input())
for case in range(1, t + 1):
    v,e,p1,p2 = map(int,input().split())
    info = list(map(int,input().split()))
    child = defaultdict(list)
    parent = defaultdict(int)
    dp = [0] * (v+1)
    dp[p1], dp[p2] = 1,1
    cnt_dp = [0] * (v+1)
    for i in range(0,len(info),2):
        p = info[i]
        c = info[i+1]
        child[p].append(c)
        parent[c] = p
    ans_p = search_parent(p1)
    ans_cnt = cnt(ans_p)
    print(f'#{case} {ans_p} {ans_cnt}')