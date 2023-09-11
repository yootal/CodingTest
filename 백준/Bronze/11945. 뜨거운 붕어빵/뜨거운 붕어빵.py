import sys
input = sys.stdin.readline

n,m = map(int,input().split())
l = []
for _ in range(n):
    inp = input().rstrip()
    l.append(inp)
    
for i in range(n):
    print(l[i][::-1])
