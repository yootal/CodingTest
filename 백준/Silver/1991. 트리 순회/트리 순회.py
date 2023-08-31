import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
from collections import defaultdict

n = int(input())
lc = defaultdict(str)
rc = defaultdict(str)

for _ in range(n):
    m,l,r = input().rstrip().split()
    if l != '.':
        lc[m] = l
    if r != '.':
        rc[m] = r

def preorder(cur):
    print(cur, end = "")
    if lc[cur]:
        preorder(lc[cur])
    if rc[cur]:
        preorder(rc[cur]) 
        
def inorder(cur):
    if lc[cur]:
        inorder(lc[cur])
    print(cur, end = "")
    if rc[cur]:
        inorder(rc[cur]) 
        
def postorder(cur):
    if lc[cur]:
        postorder(lc[cur])
    if rc[cur]:
        postorder(rc[cur]) 
    print(cur, end = "")
    
preorder('A')
print()
inorder('A')
print()
postorder('A')