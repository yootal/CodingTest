import sys
input = sys.stdin.readline

n = int(input())
stack = []
for _ in range(n):
    inp = int(input())
    if inp == 0:
        stack.pop()
    else:
        stack.append(inp)

print(sum(stack))