import sys
input = sys.stdin.readline
    
n = int(input())
snow = list(map(int,input().split()))
snow.sort()

ans = sys.maxsize
for i in range(n):
    for j in range(i+3,n):
        st = i+1 
        en = j-1
        while st < en:
            diff = (snow[i] + snow[j]) - (snow[st] + snow[en])
            if abs(ans) > abs(diff):
                ans = abs(diff)
                
            if diff < 0:
                en -= 1
            else:
                st += 1
                
print(ans) 

