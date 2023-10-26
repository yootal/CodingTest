from sys import stdin
input = stdin.readline

h,w = map(int,input().split())
memo = [list(input().rstrip()) for _ in range(h)]

cnt = 0
ans = 0
for i in range(h):
    st = -1
    en = -1
    for j in range(w):
        if memo[i][j] == '/' or memo[i][j] == '\\':
            if st == -1:
                st = j
            elif j > st:
                en = j
                ans += en - st - 1
                st = -1
            cnt += 1
            
ans += (cnt//2) 
print(ans)