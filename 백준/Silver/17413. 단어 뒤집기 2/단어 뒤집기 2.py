import sys
input = sys.stdin.readline

s = input().rstrip()
stack = []

for c in s:
    if c == '<':
        while stack:
            print(stack.pop(),end="")
        stack.append('<')
        print('<',end="")
    elif c == '>':
        stack.pop()
        print('>',end="")
    elif stack and stack[-1] == '<':
            print(c,end="")
    elif c == ' ':
        while stack:
            print(stack.pop(),end="")
        print(" ",end="")
    else:
        stack.append(c)
        
while stack:
    print(stack.pop(),end="")