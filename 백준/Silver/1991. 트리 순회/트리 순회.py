import sys
input=sys.stdin.readline
from collections import defaultdict

n = int(input())
lc = defaultdict(str)
rc = defaultdict(str)
for _ in range(n):
    p,l,r = input().rstrip().split()
    if l != '.':
        lc[p] = l
    if r != '.':
        rc[p] = r

def preorder(s):
    print(s,end="")
    if lc[s]:
        preorder(lc[s])
    if rc[s]:
        preorder(rc[s])

def inorder(s):
    if lc[s]:
        inorder(lc[s])
    print(s,end="")
    if rc[s]:
        inorder(rc[s])
    
def postorder(s):
    if lc[s]:
        postorder(lc[s])
    if rc[s]:
        postorder(rc[s])
    print(s,end="")

preorder('A')
print()
inorder('A')
print()
postorder('A')