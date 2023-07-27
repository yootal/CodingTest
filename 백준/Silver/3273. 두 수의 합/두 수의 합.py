n = int(input())
num_list = list(map(int,input().split()))
x = int(input())
check_list = [0] * 2000001

count = 0
for num in num_list:
    if check_list[x-num] == 1:
        count+=1
    else: check_list[num] = 1
        
print(count)