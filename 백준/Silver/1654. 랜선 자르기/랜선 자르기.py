k,n=map(int,input().split())
num=[int(input()) for _ in range(k)]

st=1
en=max(num)

while st<=en:
    count=0
    mid=(st+en)//2
    for i in range(k):
        count+=(num[i]//mid)
    
    if count>=n:
        st=mid+1
    else:
        en=mid-1
print(en)


