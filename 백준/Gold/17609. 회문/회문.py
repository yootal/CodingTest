from sys import stdin
input = stdin.readline

def check(s):
    l = len(s)
    flag = True
    for i in range(l//2):
        if s[i] != s[l-1-i]:
            flag = False
            break
    if not flag:
        flag2 = True
        for j in range(l//2-i):
            if s[i+j] != s[l-1-i-1-j]:
                flag2 = False
                break                
        flag3 = True
        for k in range(l//2-i):
            if s[i+1+k] != s[l-1-i-k]:
                flag3 = False
                break
        if flag2 or flag3:
            return 1
        else:
            return 2
    else:
        return 0
    
n = int(input())
for _ in range(n):
    s = input().rstrip()
    print(check(s))