for case in range(1,11):
    n = int(input())
    original = list(map(int,input().split()))
    c = int(input())
    command = list(input().rstrip().split())
    i = 0
    count = 0
    while count < c:
        if command[i] == 'I':
            idx = int(command[i+1])
            cnt = int(command[i+2])
            num = list(map(int,command[i+3:i+3+cnt]))
            original = original[:idx] + num + original[idx:]
            i = i + 3 + cnt
            count += 1
    print(f"#{case}",end=" ")
    for i in range(10):
        print(original[i],end=" ")
    print()
