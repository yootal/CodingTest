k,n=map(int,input().split())
num=list(map(int,input().split()))

st=1
en=max(num)

while st<=en:
    height=0
    mid=(st+en)//2
    for i in range(k):
        if num[i]>mid:
            height+=(num[i]-mid)
    if height>=n:
        st=mid+1
    else:
        en=mid-1
print(en)


