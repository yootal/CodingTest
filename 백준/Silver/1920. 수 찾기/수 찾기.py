import sys
input = sys.stdin.readline

a = int(input())
a_list = list(map(int,input().split()))

b = int(input())
b_list = list(map(int,input().split()))

a_list.sort()

def binary_search(target):
    left, right = 0, a-1
    
    while left <= right:
        mid = (left + right) // 2
        if target > a_list[mid]:
            left = mid + 1
        elif target < a_list[mid]:
            right = mid - 1
        else: 
            return 1
        
    return 0
    
for b1 in b_list:
    print(binary_search(b1))