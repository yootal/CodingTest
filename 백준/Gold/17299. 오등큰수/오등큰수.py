import sys
input = sys.stdin.readline

n = int(input())
num_list = list(map(int,input().split()))

stack = []
nd = {}
ans = [0] * n

for num in num_list:
    if num in nd:
        nd[num] += 1 
    else:
        nd[num] = 1
    
for n2 in range(n):
    while stack and stack[-1][1] < nd[num_list[n2]]:
        index,count = stack.pop()
        ans[index] = num_list[n2]
    stack.append((n2,nd[num_list[n2]]))
    
for s in stack:
    ans[s[0]] = -1
    
print(" ".join(map(str,ans)))