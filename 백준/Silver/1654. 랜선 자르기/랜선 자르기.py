import sys
input = sys.stdin.readline

k,n = map(int,input().split())

num = [int(input()) for _ in range(k)]
    
max_num = max(num)
left,right = 1,max_num

while left < right:
    count = 0
    mid = (left+right+1)//2
    for num1 in num:
        count += (num1//mid)
    if count >= n:
        left = mid
    else: 
        right = mid -1 

print(left)