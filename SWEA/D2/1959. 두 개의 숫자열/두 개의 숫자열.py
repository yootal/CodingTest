t = int(input())
for case in range(1,t+1):
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    if n < m:
        n,m = m,n
        a,b = b,a
    ans = 0
    for i in range(n-m+1):
        _sum = 0
        for j in range(m):
            _sum += a[i+j] * b[j]
        ans = max(ans, _sum)
    print(f'#{case} {ans}')