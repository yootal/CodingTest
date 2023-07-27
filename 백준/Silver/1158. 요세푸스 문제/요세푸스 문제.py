n,k = map(int,input().split())

len = 0
pre = [0]*(n+1)
nxt = [0]*(n+1)
ans = []

for i in range(1,n+1):
    pre[i] = n if i == 1 else i - 1
    nxt[i] = 1 if i == n else i + 1
    len += 1

i = 1
cur = 1
while len !=0:
    if i == k:
        pre[nxt[cur]] = pre[cur]
        nxt[pre[cur]] = nxt[cur]
        ans.append(cur)
        i = 1
        len -= 1
    else:
        i += 1
    cur = nxt[cur]
        
print('<',end = "")
print(", ".join(str(num) for num in ans),end = "")
print('>')