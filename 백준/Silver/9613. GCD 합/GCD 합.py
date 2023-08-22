import sys
input = sys.stdin.readline

def gcd(a,b):
    if b == 0:
        return a
    return gcd(b,a%b)

t = int(input())
for _ in range(t):
    inp = list(map(int,input().split()))
    n = inp[0]
    l = inp[1:]
    l2 = []
    for i in range(n):
        for j in range(i+1,n):
            l2.append(gcd(l[i],l[j]))
    print(sum(l2))