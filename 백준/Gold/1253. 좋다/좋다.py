import sys
input = sys.stdin.readline
    
n = int(input())
num = list(map(int,input().split()))
num.sort()

check = [False] * n

def two_pointer(st,en,i):  
    global ans 
    find = num[i] 
    while st < en:
        if st == i:
            st += 1
            continue
        if en == i:
            en -= 1
            continue
        value = num[st] + num[en]
        if value < find:
            st += 1
        elif value == find:
            if not check[i]:
                check[i] = True
                ans += 1
            return
        else:
            en -= 1
        
ans = 0
for i in range(n):
    st = 0
    en = n-1
    two_pointer(st,en,i) 
        
print(ans)