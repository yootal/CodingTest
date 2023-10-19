t  = int(input())
for case in range(1,t+1):
    string = input()
    ans = 0
    for i in range(1,31):
        if 2*i <= 31:
            if string[:i] == string[i:2*i]:
                ans = i
                break
        else:
            if string[i:31] == string[:31-i]:
                ans = i
                break
    print(f"#{case} {ans}")
