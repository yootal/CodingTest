import sys
input = sys.stdin.readline
    
n,k = map(int,input().split())
line = [0] * 1000001
for _ in range(n):
    s,e = map(int,input().split())
    for i in range(s,e):
        line[i] += 1
    
st = 0
en = 0
val = 0
while st <= en and en < 1000001:
    if val == k:
        print(st,en)
        exit()
    elif val < k:
        val += line[en]
        en += 1
    else:
        val -= line[st]
        st += 1
            
print(0,0)