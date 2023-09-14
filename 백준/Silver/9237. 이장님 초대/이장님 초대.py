import sys
input=sys.stdin.readline

n = int(input())
tree = list(map(int,input().split()))
tree.sort(reverse=True)

ans = tree[0]
rest = tree[0]
day = 1
while rest:
    rest -= 1
    if day < n and rest < tree[day]:
        rest += tree[day] - rest
    day += 1
    
print(day+1)