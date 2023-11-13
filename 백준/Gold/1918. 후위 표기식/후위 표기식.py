from sys import stdin
input = stdin.readline

ex = list(input().rstrip())
w = {'+':1,'-':1,'*':2,'/':2,'(':3,')':3}
stack = []
ans = ''
for x in ex:
    if x.isupper():
        ans += x
    else:
        if x == '(':
            stack.append(x)
        elif w[x] == 2:
            while stack and w[stack[-1]] == 2:
                ans += stack.pop()
            stack.append(x)
        elif w[x] == 1:
            while stack and stack[-1] != '(':
                ans += stack.pop()
            stack.append(x)
        elif x == ')':
            while stack and stack[-1] != '(':
                ans += stack.pop()
            stack.pop()
while stack:
    ans += stack.pop()
print(ans)    