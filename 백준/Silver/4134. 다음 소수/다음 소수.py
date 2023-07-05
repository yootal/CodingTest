import sys
input=sys.stdin.readline

def is_prime(n):
    if n <= 1:
        return False

    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False

    return True

l = []

for _ in range(int(input())):
      l.append(int(input()))
      
for l1 in l:
      while True:
            if is_prime(l1)==True:
                  print(l1)
                  break
            else: l1 += 1 