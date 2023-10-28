from sys import stdin, maxsize
from collections import defaultdict
input = stdin.readline

n = int(input())
in_num = [input() for _ in range(n)]
out_num = [input() for _ in range(n)]
idx = defaultdict(int)

for i,v in enumerate(in_num):
    idx[v] = i

cur = maxsize
ans = 0
for j in range(n-1,-1,-1):
    if cur > idx[out_num[j]]:
        cur = idx[out_num[j]]
    else:
        ans += 1
print(ans)