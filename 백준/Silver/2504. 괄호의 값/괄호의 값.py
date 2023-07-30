import sys
input = sys.stdin.readline

inp = input().rstrip()

stack = []
ans = 0
cal = 1

for s in range(len(inp)):
    if inp[s] == '(':
        stack.append('(')
        cal *= 2
    elif inp[s] == '[':
        stack.append('[')
        cal *= 3
    elif inp[s] == ')':
        if not stack or stack[-1] == '[':
            ans = 0
            break
        if inp[s-1] == '(':
            ans += cal
        stack.pop()
        cal //= 2
    else:
        if not stack or stack[-1] == '(':
            ans = 0
            break
        if inp[s-1] == '[':
            ans += cal
        stack.pop()
        cal //= 3
        
if stack:
    print(0)
else:
    print(ans)
    

    