n = int(input())

for i in range(1,n):
    print("*" * i,end="")
    print(" " * ((n - i) * 2),end="")
    print("*" * i)
    
print("*" * 2*n)

for i in range(1,n):
    print("*" * (n-i),end="")
    print(" " * (i * 2),end="")
    print("*" * (n-i))