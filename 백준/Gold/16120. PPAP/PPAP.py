from sys import stdin
input = stdin.readline

s = list(input().rstrip())
stack = []
for x in s:
    stack.append(x)
    if ''.join(stack[-4:]) == 'PPAP':
        for _ in range(3):
            stack.pop()
if len(stack) == 1 and stack[0] == 'P':
    print('PPAP')
else:
    print('NP')