import sys
input = sys.stdin.readline

n,k = map(int,input().split())
device = list(map(int,input().split()))
code = []
ans = 0    

for i in range(k):
    if device[i] in code:
        continue
    
    if len(code) < n:
        code.append(device[i])
        continue
    
    pri = []
    for c in code:
        if c in device[i:]:
            pri.append(device[i:].index(c))
        else:
            pri.append(101)
    
    target = pri.index(max(pri))
    code.remove(code[target])
    code.append(device[i])
    ans += 1
    
print(ans)
        