import sys
input = sys.stdin.readline

def bt(k,st):
    if k == 6:
        print(*arr)
        return
    for i in range(st,n):
        if not use_check[i]:
            use_check[i] = True
            arr[k] = lotto[i]
            bt(k+1,i)
            use_check[i] = False

while True:
    inp = list(map(int,input().split()))
    if inp[0] == 0:
        break
    n = inp[0]
    lotto = inp[1:]
    use_check = [False] * (n)
    arr = [0] * 6
    bt(0,0)
    print()