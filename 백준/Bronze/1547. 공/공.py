import sys
input = sys.stdin.readline

n = int(input())

cup = [1,2,3]
for _ in range(n):
    x,y = map(int, input().split())
    x_idx = cup.index(x)
    y_idx = cup.index(y)
    
    temp = cup[x_idx]
    cup[x_idx] = cup[y_idx]
    cup[y_idx] = temp
    
print(cup[0])