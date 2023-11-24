from sys import stdin
input = stdin.readline

mod = 1234567891
r = 31

l = int(input())
s = input().rstrip()

ans = 0
for i in range(l):
    n = ord(s[i]) - 96
    ans += n * (r ** i)
print(ans % mod)

