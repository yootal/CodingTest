d={0:"Soongsil",1:"Korea",2:"Hanyang"}
l=list(map(int,input().split()))
print("OK" if sum(l) >= 100 else d[l.index(min(l))])