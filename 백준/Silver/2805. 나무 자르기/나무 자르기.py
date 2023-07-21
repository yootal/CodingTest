import sys
input=sys.stdin.readline
k,n=map(int,input().split())
num=list(map(int,input().split()))

st=1
en=max(num)

while st<=en:
    height=0
    mid=(st+en)//2
    for i in num:
        if i>=mid:
            height+=(i-mid)
    if height>=n:
        st=mid+1
    else:
        en=mid-1
print(en)


