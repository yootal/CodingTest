a = []
b = []
n = int(input())
for _ in range(n):
    x,y = map(int,input().split())
    a.append(x)
    b.append(y)
print((max(a)-min(a) + max(b)-min(b)) * 2)