import sys
input = sys.stdin.readline

k,n = map(int,input().split())

num = []

for _ in range(k):
    num.append(int(input()))
    
max_num = max(num)
left,right = 1,max_num

while left <= right:
    count = 0
    mid = (left+right)//2
    for num1 in num:
        count += (num1//mid)
    if count >= n:
        left = mid + 1
    else: right = mid -1 

print(right)
    