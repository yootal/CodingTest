n = int(input())
time = [300,60,10]
ans = [0] * 3

for i in range(3):
    ans[i] = n // time[i]
    n %= time[i]
    
if n == 0:
    print(*ans)
else:
    print(-1)