import sys
input = sys.stdin.readline

formula = input().rstrip()

ans = 0
f2=formula.split("-")

for f3 in f2[0].split("+"):
    ans += int(f3)

for f4 in f2[1:]:
    f5 = f4.split("+")
    for f6 in f5:
        ans-=int(f6)
        
print(ans)