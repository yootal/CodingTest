import sys
input = sys.stdin.readline
from collections import deque
q = deque()
size = 0
for _ in range(int(input())):
    command = input().rstrip()
    
    if command == 'pop':
        if size > 0:
            print(q.popleft())
            size -= 1
        else:
            print(-1)
    elif command == 'size':
        print(size)
    elif command == 'empty':
        if size == 0:
            print(1)
        else:
            print(0)
    elif command == 'front':
        if size == 0:
            print(-1)
        else:
            print(q[0])
    elif command == 'back':
        if size == 0:
            print(-1)
        else:
            print(q[size-1])
    else:
        c,x = command.split()
        q.append(x)
        size += 1