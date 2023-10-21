def back_tracking(arr):
    global ans
    
    if arr: 
        value = sum(map(lambda x: num[x],arr))
        if value == k:
            ans += 1
            return
        elif value > k:
            return
    
    if not arr:
        st = 0
    else:
        st = arr[-1] + 1
    
    for i in range(st,n):
        if i not in arr:
            arr.append(i)
            back_tracking(arr)
            arr.pop()

t = int(input())
for case in range(1,t+1):
    n,k = map(int,input().split())
    num = list(map(int,input().split()))
    ans = 0
    back_tracking([])
    print(f"#{case} {ans}")