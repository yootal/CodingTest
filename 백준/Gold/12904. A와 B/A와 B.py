import sys
input=sys.stdin.readline

s = input().rstrip()
t = list(input().rstrip())

while len(t) != len(s):
    if t[-1] == 'A':
        t.pop()
    elif t[-1] == 'B':
        t.pop()
        t = t[::-1]
    else:
        break
        
t2 = "".join(t)
if s == t2:
    print(1)
else:
    print(0)