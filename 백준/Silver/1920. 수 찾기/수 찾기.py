import sys
input = sys.stdin.readline

a = int(input())
a_list = list(map(int,input().split()))

b = int(input())
b_list = list(map(int,input().split()))

a_list.sort()

for b1 in b_list:
    left, right = 0, a-1
    check = False
    
    while left <= right:
        mid = (left + right) // 2
        if b1 == a_list[mid]:
            check = True
            print(1)
            break
        elif b1 > a_list[mid]:
            left = mid + 1
        else:
            right = mid - 1
            
    if not check:
        print(0)