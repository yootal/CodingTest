from sys import stdin
input = stdin.readline

n = int(input())
pos = []
for _ in range(n):
    pos.append(tuple(map(int,input().split())))
    
mx = sorted(pos,key=lambda x:x[0])[n//2][0]
my = sorted(pos,key=lambda x:x[1])[n//2][1]

ans=0
for i in pos:
    ans+=(abs(mx-i[0]) + abs(my-i[1]))
print(ans)