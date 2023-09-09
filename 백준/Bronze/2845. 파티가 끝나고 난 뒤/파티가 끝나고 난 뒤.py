l,p = map(int,input().split())
news = list(map(int,input().split()))
v = l*p
for n in news:
    print(n-v,end = " ")    
    