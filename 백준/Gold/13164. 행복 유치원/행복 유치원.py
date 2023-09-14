import sys
input=sys.stdin.readline

n,k = map(int,input().split())
h = list(map(int,input().split()))

hd = []

for i in range(1,n):
    hd.append(h[i] - h[i-1])

hd.sort()
print(sum(hd[:n-k]))