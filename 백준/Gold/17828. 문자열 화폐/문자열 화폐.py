from sys import stdin
input = stdin.readline

n,x = map(int,input().split())

if n > x or n * 26 < x:
    print('!')
    exit()
    
else:
    ans = ['A'] * n
    x -= n
    idx = n-1
    while x > 0:
        if x >= 25:
            ans[idx] = 'Z'
            idx -= 1
            x -= 25
        else:
            ans[idx] = chr(x + 65)
            break
    print(''.join(ans))