t = int(input())
for case in range(1, t + 1):
    inp = input().rstrip()
    ans = 0
    stack = []
    for x in range(len(inp)):
        if inp[x] == ')':
            if inp[x - 1] == '(':
                stack.pop()
                ans += len(stack)
            elif inp[x - 1] == ')':
                stack.pop()
                ans += 1
        else:
            stack.append('(')
    print(f'#{case} {ans}')