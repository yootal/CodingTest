import sys
input = sys.stdin.readline
from collections import defaultdict

n,m = map(int,input().split())
gg = defaultdict(list)
gg_mem = defaultdict(str)

for _ in range(n):
    gg_name = input().rstrip()
    gg_cnt = int(input())
    for _ in range(gg_cnt):
        mem_name = input().rstrip()
        gg[gg_name].append(mem_name) 
        gg_mem[mem_name] = gg_name
        
for _ in range(m):
    inp = input().rstrip()
    q_num = int(input())
    if q_num == 1:
        print(gg_mem[inp])
    else:
        gg[inp].sort()
        for output in gg[inp]:
            print(output)
