def recursion(cnt):
    if cnt == b:
        return a 
    return a * recursion(cnt+1)

for case in range(1,11):
    n = int(input())
    a,b = map(int,input().split())
    ans = recursion(1)
    print(f"#{case} {ans}")