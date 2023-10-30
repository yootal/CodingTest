from sys import stdin
input = stdin.readline        

n = int(input())
ball = list(input().rstrip())

cur = ball[-1]
check = False
cnt1 = 0
cnt2 = 0
for i in range(n-1,-1,-1):
    if ball[i] == cur and not check:
        continue
    elif ball[i] == cur:
        cnt1 += 1 
    elif ball[i] != cur:
        if not check:
            check = True
        cnt2 += 1

print(min(cnt1,cnt2))