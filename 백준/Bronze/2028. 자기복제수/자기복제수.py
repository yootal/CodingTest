import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    n2 = str(n**2)
    n_len = len(str(n))
    
    if str(n) == n2[-n_len:]:
        print("YES")
    else:
        print("NO")