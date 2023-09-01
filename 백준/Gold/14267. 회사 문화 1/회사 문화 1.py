import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
from collections import defaultdict

n,m = map(int,input().split())
immediate_superior = defaultdict(list) # 각 직속상사에 부하 넣음
superior_num = [0] + list(map(int,input().split())) # 각 부하의 직속상사 번호
praise = [0] * (n+1) # 칭찬

for i in range(1,n+1):
    if superior_num[i] != -1:
        immediate_superior[superior_num[i]].append(i)

for j in range(m):
    i,w = map(int,input().split())
    praise[i] += w
    
def dfs(num):
    for i in immediate_superior[num]:
        praise[i] += praise[num]
        dfs(i)
        
dfs(1)
print(*praise[1:])