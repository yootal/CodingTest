n = int(input())

for i in range(n):
    print(" " * i,end="")
    print("*" * ((n-i) * 2 - 1))

for i in range(2,n+1):
    print(" " * (n-i),end="")
    print("*" * ((i * 2)-1))