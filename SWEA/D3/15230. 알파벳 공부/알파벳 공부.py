t = int(input())
for case in range(1, t + 1):
    s = input().rstrip()
    ans = 0
    code = 97
    for i in range(len(s)):
        if i == 0 and s[i] == chr(code):
            ans += 1
            code += 1
        elif s[i] == chr(code):
            ans += 1
            code += 1
        else:
            break
    print(f'#{case} {ans}')