import sys
input = sys.stdin.readline
    
n = int(input())
sol = list(map(int,input().split()))
sol.sort()

ans = sys.maxsize
a1,a2,a3 = 0,0,0

for i in range(n-2):
    st = i + 1
    en = n - 1
    while st < en:
        s = sol[i] + sol[st] + sol[en]
        if ans > abs(s):
            a1 = sol[i]
            a2 = sol[st]
            a3 = sol[en]
            ans = abs(s)
        
        if s < 0:
            st += 1
        else:
            en -= 1
            
print(a1,a2,a3)