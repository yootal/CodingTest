import sys
input = sys.stdin.readline

n,m = map(int,input().split())
package = []
unit = []
for _ in range(m):
    a,b = map(int,input().split())
    package.append(a)
    unit.append(b)

min_p = min(package)
min_u = min(unit)

ans1 = (min_p * (n // 6)) + (min_u * (n % 6))
ans2 = min_u * n
ans3 = min_p * (n//6+1)

print(min(ans1,ans2,ans3))