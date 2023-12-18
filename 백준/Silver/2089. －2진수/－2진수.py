from sys import stdin
input = stdin.readline

n = int(input())
if n == 0:
    print(0)
else:
    ans = []
    while n:
        if n < 0:
            if -n % 2 == 0:
                n = -n // 2
                ans.append('0')
            else:
                n = -n // 2 + 1
                ans.append('1')
        else:
            ans.append(str(n % 2))
            n = -(n // 2)
    print(''.join(reversed(ans)))