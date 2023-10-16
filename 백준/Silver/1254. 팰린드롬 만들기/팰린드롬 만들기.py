from sys import stdin
input = stdin.readline

s = input().rstrip()

st = 0
en = len(s)

while True:
    mid = (st + en) // 2
    if (en - st) % 2 == 0:
        if s[st:mid] != s[mid:en][::-1]:
            st += 1
        else:
            break
    else:
        if s[st:mid] != s[mid+1:en][::-1]:
            st += 1
        else:
            break

print(len(s) + st)
