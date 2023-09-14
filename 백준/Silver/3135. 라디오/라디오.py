import sys
input=sys.stdin.readline

a,b = map(int,input().split())
n = int(input())
mhz = []
for _ in range(n):
    mhz.append(int(input()))
    
min_cnt = sys.maxsize
for m in mhz:
    min_cnt = min(min_cnt, abs(m-b))
    
print(min(abs(a-b),min_cnt + 1))