def solve(arr,loop,idx,en,check):
    global ans
    if loop == 0:
        x = ""
        for item in arr:
            x += str(item)
        ans = max(ans,int(x))
        return
    
    if check == True:
        arr[idx],arr[idx-1] = arr[idx-1],arr[idx]
        solve(arr,loop-1,idx,en,check)
        return
    
    if idx+1 == en:
        cnt = [0,0,0,0,0,0,0,0,0,0]
        for x in arr:
            cnt[x] += 1
            if cnt[x] >= 2:
                x = ""
                for item in arr:
                    x += str(item)
                ans = max(ans,int(x))
                return
        arr[idx],arr[idx-1] = arr[idx-1],arr[idx]
        solve(arr,loop-1,idx,en,True)
        return
    
    _max = max(arr[idx+1:en])
    if arr[idx] < _max:
        for i in range(en-1,idx,-1):
            if arr[i] == _max:
                arr[idx],arr[i] = arr[i],arr[idx]
                solve(arr,loop-1,idx+1,en,check)
                arr[idx],arr[i] = arr[i],arr[idx]
    else:
        solve(arr,loop,idx+1,en,check)
                
t = int(input())
for case in range(1,t+1):
    inp = list(input().rstrip().split())
    num = list(map(int,inp[0]))
    loop = int(inp[1])
    ans = 0
    solve(num,loop,0,len(num),False)
    print(f"#{case} {ans}")