import sys
input=sys.stdin.readline

n = int(input())
tree = list(map(int,input().split()))
tree.sort(reverse=True)

for i in range(n):
    tree[i] = tree[i] + i + 1 # 심는 일 자라는 일

print(max(tree) + 1)