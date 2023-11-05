from sys import stdin
input = stdin.readline

def count(p):
    max_cnt = 0
    for i in range(len(s)-1,-1,-1):
        if s[i] == p[-1]:
            j = 1
            cnt = 1
            while i-j >= 0 and j+1 <= len(p) and s[i-j] == p[-1-j]:
                cnt += 1
                j += 1
            max_cnt = max(max_cnt,cnt)
    return max_cnt

s = input().rstrip()
p = list(input().rstrip())

ans = 0
while p:
    equal_cnt = count(p)
    for _ in range(equal_cnt):
        p.pop()
    ans += 1

print(ans)