import sys
input=sys.stdin.readline

t = int(input())
for i in range(1,t+1) :
    points = list(map(int,input().split()))
    triangle = list(map(lambda x: x**2, points))
    
    if max(triangle) == sum(triangle) - max(triangle):
        print(f"Case #{i}: YES")
    else:
        print(f"Case #{i}: NO")