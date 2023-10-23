for case in range(1,11):
    n,num = input().rstrip().split()
    n = int(n)
    num = list(num)
    while True:
        flag = True
        for i in range(n-1):
            if num[i] == num[i+1]:
                break
            if i == n-2:
                flag = False
                break
        if not flag:
            break    
        num.pop(i+1)
        num.pop(i)
        n -= 2
    ans = ''.join(num)
    print(f"#{case} {ans}")
