from sys import stdin
input = stdin.readline

n = int(input())
sign = list(input().rstrip().split())

def bt2(pre,idx,arr2):
    if len(arr2) == n+1:
        print(''.join(str(x) for x in arr2))
        for i in range(10):
            bt(i,0,[i])
    for i in range(9,-1,-1):
        if i not in arr2:
            if sign[idx] == '<':
                if i > pre:
                    arr2.append(i)
                    bt2(i,idx + 1,arr2)
                    arr2.pop()
            else:
                if i < pre:
                    arr2.append(i)
                    bt2(i,idx + 1,arr2)
                    arr2.pop()

def bt(pre,idx,arr):
    if len(arr) == n+1:
        print(''.join(str(x) for x in arr))
        exit()
    for i in range(10):
        if i not in arr:
            if sign[idx] == '<':
                if i > pre:
                    arr.append(i)
                    bt(i,idx + 1,arr)
                    arr.pop()
            else:
                if i < pre:
                    arr.append(i)
                    bt(i,idx + 1,arr)
                    arr.pop()

for i in range(9,-1,-1):
    bt2(i,0,[i])
       

