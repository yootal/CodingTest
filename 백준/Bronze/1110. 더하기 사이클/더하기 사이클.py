from sys import stdin
input = stdin.readline

num = list(map(int,list(input().rstrip())))
l = [0,0]

if len(num) < 2:
    l[1] = num[0]
    st = 0
    en = num[0]
else:
    l[0] = num[0]
    l[1] = num[1]
    st = num[0]
    en = num[1]

ans = 0
while True:    
    ans += 1
    c = l[0] + l[1]
    l[0] = l[1]
    l[1] = c % 10
    if st == l[0] and en == l[1]:
        break

print(ans)