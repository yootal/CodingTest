import sys
input = sys.stdin.readline

n = int(input())
egg = [list(map(int,input().split())) for _ in range(n)]
ans = 0

def bt(now,k):
    global ans
    
    if now == n:
        ans = max(ans,k)
        return
    
    if egg[now][0] <= 0:
        bt(now+1,k)
    else:
        for i in range(n):
            if i == now:
                continue
            if egg[i][0] > 0:
                egg[now][0] -= egg[i][1]
                egg[i][0] -= egg[now][1]
                if egg[now][0] <= 0:
                    k += 1
                if egg[i][0] <= 0:
                    k += 1
                bt(now+1,k)
                if egg[now][0] <= 0:
                    k -= 1
                if egg[i][0] <= 0:
                    k -= 1
                egg[now][0] += egg[i][1]
                egg[i][0] += egg[now][1]
            else:
                bt(now+1,k)
            
bt(0,0)
print(ans)