from sys import stdin
input = stdin.readline

l,r = input().rstrip().split()
l_len = len(l)
r_len = len(r)
if l_len < r_len:
    print(0)
else:
    ans = 0
    idx = 0
    pre = True
    while idx != l_len:
        if pre and l[idx] == r[idx]:
            if r[idx] == '8':
                ans += 1
        elif int(l[idx]) < int(r[idx]):
            pre = False
        idx += 1
    print(ans)