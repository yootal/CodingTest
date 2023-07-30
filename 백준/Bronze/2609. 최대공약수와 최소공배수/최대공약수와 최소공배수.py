import sys
input = sys.stdin.readline

a,b = map(int,input().split())

lcm = 0
gcd = 0

for i in range(1,b+1):
    if b % i == 0 and a % i == 0 :
        gcd = i

x = 1
while True:
    if (b * x) % a == 0:
        lcm = b * x
        break
    x += 1

print(gcd)
print(lcm)