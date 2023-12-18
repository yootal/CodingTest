from sys import stdin
input = stdin.readline

n,k = map(int,input().split())
length = 1
exp = 1

while k > 9 * length * exp:
    k -= 9 * length * exp
    exp *= 10
    length += 1
    
result = exp + (k-1) // length
print(str(result)[(k-1) % length] if result <= n else -1)