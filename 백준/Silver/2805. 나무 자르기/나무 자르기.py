import sys
input = sys.stdin.readline

n,cut = map(int,input().split())

trees = list(map(int,input().split()))
    
highest = max(trees)
left,right = 1,highest

while left <= right:
    count = 0
    mid = (left+right)//2
    for t in trees:
        if mid <= t:
            count += (t-mid)
    if count >= cut:
        left = mid + 1
    else: right = mid -1 

print(right)