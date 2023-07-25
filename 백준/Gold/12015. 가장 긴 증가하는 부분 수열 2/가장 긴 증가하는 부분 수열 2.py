import sys
input=sys.stdin.readline

n = int(input())
num_list = list(map(int,input().split()))

seq = [0]
for num in num_list:
    if seq[-1] < num:
        seq.append(num)
    else:
        left = 0
        right = len(seq)
        while left < right:
            mid = (left + right) // 2
            if seq[mid] < num:
                left = mid + 1
            else:
                right = mid
        seq[right] = num
        
print(len(seq)-1)
    