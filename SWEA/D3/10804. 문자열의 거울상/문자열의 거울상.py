mirror = {'b': 'd', 'd': 'b', 'p': 'q', 'q': 'p'}
t = int(input())
for case in range(1, t + 1):
    s = list(input())
    ans = ''
    for x in range(len(s) - 1, -1, -1):
        ans += mirror[s[x]]
    print(f'#{case} {ans}')
