import sys
input = sys.stdin.readline

towers = []
stack = []

n = int(input())
for _ in range(n):
    towers.append(int(input()))
    
ans = 0
for t in towers:
    while stack and stack[-1] <= t:
        stack.pop()
    stack.append(t)
    ans += len(stack)-1
    
print(ans)