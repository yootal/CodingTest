t = int(input())
for case in range(1,t+1):
    inp = list(input().rstrip())
    st = inp[0]
    cnt = 0
    for i in range(1,len(inp)):
        if inp[i] != inp[i-1]:
            cnt += 1
            st = inp[i]
    if inp[0] == '1':
        cnt += 1
    print(f"#{case} {cnt}")