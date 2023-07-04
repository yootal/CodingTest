import sys

input=sys.stdin.readline

n = int(input())

def fac(n):
      if n==1 or n==0:
            return 1
      else: 
            return n*fac(n-1)
      
print(fac(n))
