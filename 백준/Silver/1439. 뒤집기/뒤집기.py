import sys
input = sys.stdin.readline

s = input().rstrip()

flag = s[0]    
check = flag
ans = 0

for i in range(len(s)):
    if s[i] != check: 
        check = s[i]
        if check != flag:
            ans += 1

print(ans)
            
        