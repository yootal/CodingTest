a,b = map(int,input().split())
l = list(map(int,input().split()))

max_v = 0

for i in range(len(l)-2):
    for j in range(i+1,len(l)-1):
        for k in range(j+1,len(l)):
            s = l[i]+l[j]+l[k]
            if s <= b:
                max_v = max(max_v,s)    
                
print(max_v)