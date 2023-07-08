import sys 
input = sys.stdin.readline

def star(n,c):
    global arr
    n2=n//3
    if n2 == 0:
        return
    
    for k in range(c):
        for k2 in range(c):
            for i in range(n2+(n*k),n2*2+(n*k)):
                for j in range(n2+(n*k2),n2*2+(n*k2)):
                    arr[i][j] = " "
    return star(n2,c*3)
    
n = int(input())
arr = [["*"]*n for _ in range(n)]

star(n,1)

for arr2 in arr:
    print("".join(arr2))