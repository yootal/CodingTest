import sys
input = sys.stdin.readline

people = int(input())
time = list(map(int,input().split()))
time.sort()

count = 0
pre = 0
for t in time:
    count += (t+pre)
    pre += t
    
print(count)