from sys import stdin
input = stdin.readline

n,m,k = map(int,input().split())
dp = [[1] * (m+1) for _ in range(n+1)] # dp[a의 개수][z의 개수]
for i in range(1,n+1):
    for j in range(1,m+1):
        dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
if dp[n][m] < k:
    print(-1)
else:
    ans = []
    while True:
        if n == 0 or m == 0:
            ans.append('z'*m)
            ans.append('a'*n)
            break
        flag = dp[n-1][m] # a 고정 이후 -> 될 수 있는 문자 개수
        if k <= flag: # 현재 인덱스 알파벳 a인데, 그 범위 안에 k가 속할 때
            ans.append('a') # a로 고정
            n -= 1
        else: # k가 더 크면, 현재 인덱스의 알파벳 z
            ans.append('z')
            m -= 1 # z로 고정
            k -= flag # 현재 알파벳을 a로 가지는 k번째 문자열보다 앞서는 문자들을 후보에서 제거
    print(''.join(ans))