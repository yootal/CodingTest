def back_tracking(cur,check):
    global _max,_min
    if check:
        x = int(''.join(num))
        _max = max(_max,x)
        _min = min(_min,x)
        return
    for i in range(cur+1,n):
        if num[i] == '0' and cur == 0:
            continue
        num[cur],num[i] = num[i],num[cur]
        back_tracking(i,True)
        num[cur],num[i] = num[i],num[cur]
        
t = int(input())
for case in range(1,t+1):
    num = list(input().rstrip())
    if num[0] == '0':
        print(f"#{case} 0 0")
        continue
    n = len(num)
    _max = int(''.join(num))
    _min = _max
    for i in range(n-1):
        back_tracking(i,False)
    print(f"#{case} {_min} {_max}")
