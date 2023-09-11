import sys
input=sys.stdin.readline

n = int(input())
tower = list(map(int,input().split()))
stack = []

for i in range(n):
    stack.append((tower[i],i))
    
stack2 = []
ans = [0] * n
cnt = n

while cnt > 0:
    while stack and stack2 and stack2[-1][0] < stack[-1][0]:
        t,idx = stack2.pop()
        ans[idx] = stack[-1][1] + 1
    stack2.append(stack.pop())
    cnt -= 1
    
print(*ans)