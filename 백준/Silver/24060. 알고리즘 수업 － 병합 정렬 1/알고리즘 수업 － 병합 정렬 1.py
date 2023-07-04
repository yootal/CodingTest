import sys
input=sys.stdin.readline

count = 0

def merge_sort(A, p, r):
    if p < r:
        q = (p + r) // 2
        merge_sort(A, p, q)
        merge_sort(A, q + 1, r)
        merge(A, p, q, r)

def merge(A, p, q, r):
    i = p
    j = q + 1
    tmp = []
    
    while i <= q and j <= r:
        if A[i] <= A[j]:
            tmp.append(A[i])
            i += 1
        else:
            tmp.append(A[j])
            j += 1

    while i <= q:
        tmp.append(A[i])
        i += 1

    while j <= r:
        tmp.append(A[j])
        j += 1

    i = p
    t = 0

    while i <= r:
        global count  
        global b
        A[i] = tmp[t]
        count += 1
        if count == b:
              print(tmp[t])
        i += 1
        t += 1
      
a,b = map(int,input().split(" "))
c = list(map(int,input().split(" ")))
merge_sort(c,0,a-1)
if count < b:
      print(-1)
      
      


