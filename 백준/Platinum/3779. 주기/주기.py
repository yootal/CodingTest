from sys import stdin
input = stdin.readline

def failure(s):
    f = [0] * len(s)
    j = 0
    for i in range(1,len(s)):
        while j > 0 and s[i] != s[j]:
            j = f[j-1]
        if s[i] == s[j]:
            j += 1
            f[i] = j
    return f

case = 0
while True:
    case += 1
    n = int(input())
    if n == 0:
        break
    s = input().rstrip()
    f = failure(s)

    print(f'Test case #{case}')
    for i in range(1,n):
        suffix = f[i] # 접미사
        prefix = (i+1) - f[i] # 접두사
        if suffix % prefix == 0 and suffix // prefix > 0:
            print(i+1,(suffix//prefix) + 1)
    print()
            