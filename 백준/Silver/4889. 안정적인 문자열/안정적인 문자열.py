from sys import stdin
input = stdin.readline        

case = 0
while True:
    case += 1
    s = list(input().rstrip())
    if '-' in s:
        break
    
    ans = 0
    stack = []
    for x in s:
        if x == '{':
            if not stack or stack[-1] == '{':
                stack.append('{')
        if x == '}':
            if stack and stack[-1] == '{':
                stack.pop()
            else:
                ans += 1
                stack.append('{')
                
    if len(stack) != 0:
        ans += len(stack) // 2
        
    print(f'{case}. {ans}')