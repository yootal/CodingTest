from sys import stdin
from collections import defaultdict
input = stdin.readline

n,m = map(int,input().split())
line = defaultdict(list)
cnt = 0
for i in range(n):
    row = list(map(int,input().split()))
    for j in range(m):
        if row[j]:
            for k in line.keys():
                if i >= line[k][-1][0] and j >= line[k][-1][1]:
                    line[k].append((i,j))
                    break
            else:
                cnt += 1
                line[cnt].append((i,j))
print(cnt)