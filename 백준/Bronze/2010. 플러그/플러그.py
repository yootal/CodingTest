import sys
input = sys.stdin.readline

n = int(input())
total = 0
for i in range(n):
    total += int(input())
    
print(total-(n-1))
