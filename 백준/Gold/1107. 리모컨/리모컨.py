from sys import stdin, maxsize
input = stdin.readline

def check(x):
    if x in button:
        return True
    while x != 0:
        if (x % 10) in button:
            return True
        x //= 10
    return False
    
n = int(input())
m = int(input())
if m != 0:
    button = set(map(int,input().split()))
else:
    button = set()

if n == 100:
    print(0)
    exit()
    
ans1 = abs(n - 100)
ans2 = len(str(n))
ans3 = len(str(n))

num1 = n
num2 = n

num1_range = ans2
while check(num1):
    num1 += 1
    ans2 += 1
    if len(str(num1)) > num1_range:
        num1_range += 1
        ans2 += 1
    if ans2 > ans1:
        ans2 = maxsize
        break
    
num2_range = ans3
while check(num2):
    num2 -= 1
    ans3 += 1
    if len(str(num2)) < num2_range:
        num2_range -= 1
        ans3 -= 1
    if ans3 > ans1:
        ans3 = maxsize
        break
    if num2 < 0:
        if 0 in button:
            ans3 = maxsize
        break

print(min(ans1,ans2,ans3))