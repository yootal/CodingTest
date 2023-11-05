from sys import stdin, maxsize
from itertools import permutations
input = stdin.readline

s = list(input().rstrip())
l = len(s)
before = int(''.join(s))
ans = maxsize
for comb in permutations(s,l):
    num = int(''.join(comb))
    if num > before:
        ans = min(ans,num)
        
if ans == maxsize:
    print(0)
else:
    print(ans)