from sys import stdin
from collections import deque
input = stdin.readline

n = int(input())
s = deque([input().rstrip() for _ in range(n)])
ans = ""
while True:
    if len(s) == 1:
        ans += s.pop()
        break
    if s[0] == s[-1]:
        flag = True
        for i in range(1,len(s)//2):
            if s[i] < s[-1-i]:
                flag = False
                ans += s.popleft()
                break
            if s[i] > s[-1-i]:
                flag = False
                ans += s.pop()
                break
        if flag:
            ans += s.pop()
    elif s[0] < s[-1]:
        ans += s.popleft()
    elif s[0] > s[-1]:
        ans += s.pop()
        
for j in range(0,len(ans),80):
    print(ans[j:j+80])