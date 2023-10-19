from collections import Counter

t = int(input())
for i in range(1,t+1):
    n = int(input())
    cnt = Counter(list(map(int,input().split())))
    
    ans_k = 0
    ans_v = 0
    for k,v in cnt.items():
        if ans_v < v:
            ans_v = v
            ans_k = k
        if ans_v == v:
            ans_k = max(ans_k,k)
    
    print(f"#{n} {ans_k}")
        