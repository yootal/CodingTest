from sys import stdin, maxsize
from collections import defaultdict
input = stdin.readline

def dfs(cur,vis):
    if vis == (1 << n) - 1: # 1000(2) - 1 -> 0111(2) 0, 1, 2 방문 확인 
        if cost[cur][0]:
            return cost[cur][0]
        else:
            return maxsize
    if (cur,vis) in dp:
        return dp[(cur,vis)]
    min_c = maxsize
    for nxt in range(1,n):
        if not cost[cur][nxt] or vis & (1 << nxt): # 방문했거나 값이 없거나
            continue
        c = dfs(nxt, vis | (1 << nxt)) + cost[cur][nxt]
        min_c = min(min_c,c)
    dp[(cur,vis)] = min_c
    return min_c

n = int(input())
cost = [list(map(int,input().split())) for _ in range(n)]
dp = defaultdict(int)
print(dfs(0,1))