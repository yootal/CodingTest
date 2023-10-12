from sys import stdin
input = stdin.readline

def prime(x):
    if x == 1:
        return False
    for i in range(2,int(x**0.5)+1):
        if x % i == 0:
            return False
    return True

def palindrome(x):
    if str(x) == str(x)[::-1]:
        return True
    return False

n = int(input())
while True:
    if prime(n) and palindrome(n):
        print(n)
        break
    n += 1