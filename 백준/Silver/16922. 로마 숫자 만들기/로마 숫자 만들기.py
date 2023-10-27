from sys import stdin
from collections import defaultdict
input = stdin.readline

def solve(s,cnt):
    if cnt == n:
        if s not in num:
            num.add(s)
        return
    for x in m:
        if s+dict[x] not in cnt_s[cnt+1]:
            cnt_s[cnt+1].add(s+dict[x])
            solve(s+dict[x],cnt+1)

dict = {'I':1,'V':5,'X':10,'L':50}
cnt_s = defaultdict(set)
m = dict.keys()
n = int(input())
num = set()
solve(0,0)
print(len(num))