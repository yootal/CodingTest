import sys
input = sys.stdin.readline

ans = 0

inp = input().rstrip()

stack = []

for s in range(len(inp)):
    if inp[s] == ')':
        if inp[s-1] == '(':
            stack.pop()
            ans += len(stack)
        elif inp[s-1] == ')':
            stack.pop()
            ans += 1    
            
    else:
        stack.append('(')

print(ans)