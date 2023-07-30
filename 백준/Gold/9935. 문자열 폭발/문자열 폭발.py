import sys
input = sys.stdin.readline

str = list(input().rstrip())
bomb = input().rstrip()
b_len = len(bomb)

stack = []

for i in range(len(str)):
    stack.append(str[i])
    if "".join(stack[-b_len:]) == bomb:
        for _ in range(b_len):
            stack.pop()
if stack:
    print("".join(stack))
else:
    print("FRULA") 