import sys
input = sys.stdin.readline

n = int(input())

p = 1
for i in range(2,n+1):
    p *= i
    
rp = str(p)[::-1]

cnt = 0
for rp2 in rp:
    if rp2 != '0':
        break
    else:
        cnt += 1
        continue

print(cnt)
