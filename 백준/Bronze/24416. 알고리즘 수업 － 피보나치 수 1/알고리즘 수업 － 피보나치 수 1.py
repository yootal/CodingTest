import sys
input=sys.stdin.readline
n = int(input())

count1 = 0
count2 = 0

def fib(n):
    global count1
    if n == 1 or n == 2:
        count1 += 1
        return 1 
    else: 
        return (fib(n - 1) + fib(n - 2))

def fibonacci(n):
    global count2
    for i in range(3, n+1):
        count2 += 1

fib(n)
fibonacci(n)
print(count1, count2)