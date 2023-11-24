from sys import stdin
input = stdin.readline

def make_ans(x,y,ans,_a,_b):
    if dp[x][y] == 0:
        ans = b[0:y] + ans
        ans = a[0:x] + ans
        return ans
    
    if dp[x-1][y] == dp[x][y]:
        _a = a[x-1] + _a
        return make_ans(x-1,y,ans,_a,_b)
    
    elif dp[x][y-1] == dp[x][y]:
        _b = b[y-1] + _b
        return make_ans(x,y-1,ans,_a,_b)
    
    else:
        ans = _b + ans
        ans = _a + ans
        ans = a[x-1] + ans
        return make_ans(x-1,y-1,ans,'','')

while True:
    try:
        a,b = input().split()
    except:
        break
    
    dp = [[0 for _ in range(len(b)+1)] for _ in range(len(a)+1)]
    for i in range(1,len(a)+1):
        for j in range(1,len(b)+1):
            if a[i-1] == b[j-1]:
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i-1][j],dp[i][j-1])

    ans = make_ans(len(a),len(b),'','','')            
    print(ans)