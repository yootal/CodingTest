import sys
input = sys.stdin.readline

n = int(input())
if n < 5 and n % 2 != 0:
    print(-1)
    exit()

ans = n//5
if (n%5) % 2 == 0:
    ans += (n%5)//2
else:
    ans -= 1
    ans += (n%5+5) // 2 

print(ans)
