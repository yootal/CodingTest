import sys
input = sys.stdin.readline
from collections import defaultdict
    
n,m = map(int,input().split())
pw_dict = defaultdict(str)
for _ in range(n):
    inp = input().rstrip().split()
    pw_dict[inp[0]] = inp[1]

for _ in range(m):
    print(pw_dict[input().rstrip()])