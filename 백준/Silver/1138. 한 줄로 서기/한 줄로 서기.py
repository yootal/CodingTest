from sys import stdin
input = stdin.readline

n = int(input())
seq = list(map(int,input().split()))

ans = []
for c in range(n,0,-1):
    if not ans:
        ans.append(c)
    else:
        cnt = 0
        for i in range(len(ans)+1):
            if cnt == seq[c-1]:
                ans.insert(i,c)
                break
            if ans[i] > c:
                cnt += 1
print(*ans)