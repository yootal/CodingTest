import sys
from bisect import bisect_left
input = sys.stdin.readline

m,n = map(int,input().split())
space = [list(map(int,input().split())) for _ in range(m)]
compress = []

for i in range(m):
    space2 = []
    sort_space = sorted(space[i])
    for j in range(n):
        space2.append(bisect_left(sort_space,space[i][j]))
    compress.append(space2)
    
ans = 0
for i in range(m-1):
    for j in range(i+1,m):
        if compress[i] == compress[j]:
            ans += 1
            
print(ans)
