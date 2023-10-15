from sys import stdin
from collections import defaultdict
input = stdin.readline
tree = defaultdict(int)
total = 0

while True:
    name = input().rstrip()
    if not name:
        break
    tree[name] += 1
    total += 1
    
l = sorted(list(tree.keys()))
for t in l:
    print(f"{t} {tree[t]/total*100:.4f}")