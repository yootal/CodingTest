import sys
input=sys.stdin.readline

n,m = map(int,input().split())
num_list = list(map(int,input().split()))

check = [0]*m
# check[0] = 1
check[num_list[0]%m] += 1

# total = 0

for i in range(1,n):
    num_list[i] = (num_list[i-1]+num_list[i])%m
    check[num_list[i]]+=1

# for i in range(n):
#     total += num_list[i]
#     r = total % m
#     check[r] += 1

count = check[0]
for j in check:
    count += j*(j-1)//2
    
# count = 0
# for i in check:
#     count += i*(i-1)//2
    
print(count)