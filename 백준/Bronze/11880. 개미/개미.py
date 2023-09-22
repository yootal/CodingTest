import sys
input=sys.stdin.readline

for _ in range(int(input())):
    a,b,c = map(int,input().split())
    
    ans1 = a**2 + (b+c)**2
    ans2 = b**2 + (a+c)**2
    ans3 = c**2 + (a+b)**2
    
    print(min(ans1,ans2,ans3))
