import sys
input = sys.stdin.readline

l,c = map(int,input().split())
alp = list(input().rstrip().split())
alp.sort()
used = [False] * c
arr = [[] for _ in range(l)]
cnt = 0
consonant = {'a','e','i','o','u'}

def bt(k,st):
    global cnt
    if k == l:
        if cnt >= 1 and l - cnt >= 2:
            print(''.join(arr))
            return
        else:
            return
    for i in range(st,c):
        if not used[i]:
            used[i] = True
            arr[k] = alp[i]
            if alp[i] in consonant:
                cnt += 1
            bt(k+1,i)
            used[i] = False
            if alp[i] in consonant:
                cnt -= 1

bt(0,0)