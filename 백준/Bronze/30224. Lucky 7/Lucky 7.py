x=int(input())
if x%7==0:
    ans=1
    while x>0:
        if x%10==7:
            ans=3
        x//=10
else:
    ans=0
    while x>0:
        if x%10==7:
            ans=2
        x//=10
print(ans)