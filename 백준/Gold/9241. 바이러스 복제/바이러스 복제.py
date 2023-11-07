from sys import stdin
input = stdin.readline

a = input().rstrip()
b = input().rstrip()
min_len = min(len(a),len(b))

st = 0
while st < min_len and a[st] == b[st]:
    st += 1
    
en = 0
while en < min_len and a[len(a)-1-en] == b[len(b)-1-en]:
    en += 1

if st < min_len - en:
    print(len(b)-en-st)
else:
    if a > b:
        print(0)
    else:
        print(len(b)-len(a))