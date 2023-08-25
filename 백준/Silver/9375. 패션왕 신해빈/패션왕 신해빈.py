import sys
input = sys.stdin.readline
from collections import defaultdict
    
t = int(input())
for _ in range(t):
    dict = defaultdict(int)
    n = int(input())
    for _ in range(n):
        inp = input().rstrip().split()
        dict[inp[1]] += 1
    cnt = 1
    for c in dict:
        cnt *= (dict[c] + 1)
    print(cnt - 1)