import sys
input = sys.stdin.readline

count = 0

for _ in range(int(input())):
    inp = input().rstrip()
    
    stack = []
    
    for s in inp:
        if stack and stack[-1] != s:
            stack.append(s)
        elif stack and stack[-1] == s:
            stack.pop()
        else:
            stack.append(s)
        
    if len(stack) == 0:
        count += 1
            
print(count)

    