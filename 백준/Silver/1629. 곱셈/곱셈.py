import sys
input = sys.stdin.readline

a1,b1,c1 = map(int,input().split())

def q(a,b,c):
    if b == 1:
        return a % c
    else:   
        val = q(a,b//2,c)
        if b%2 == 0:
            return (val * val) % c
        else:
            return (val * val * a) % c

print(q(a1,b1,c1))