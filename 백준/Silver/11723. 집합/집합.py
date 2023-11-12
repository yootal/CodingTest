from sys import stdin
input = stdin.readline

m = int(input())
s = set()
for _ in range(m):
    inp = input().rstrip().split()
    if len(inp) == 1:
        if inp[0] == 'all':
            s = set([i for i in range(1, 21)])
        else:
            s = set()
    else:
        command = inp[0] 
        n = int(inp[1])
        if command == 'add':
            s.add(n)
        elif command == 'remove':
            s.discard(n)
        elif command == 'check':
            if n in s:
                print(1)
            else:
                print(0)
        elif command == 'toggle':
            if n in s:
                s.discard(n)
            else:
                s.add(n)