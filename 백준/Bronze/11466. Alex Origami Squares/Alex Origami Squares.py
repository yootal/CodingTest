import sys
input = sys.stdin.readline

inp = list(map(int,input().split()))
inp.sort()
l1 = inp[1]/3 if inp[1]/3 <= inp[0] else inp[0]
l2 = inp[0]/2
print(max(l1, l2))
    