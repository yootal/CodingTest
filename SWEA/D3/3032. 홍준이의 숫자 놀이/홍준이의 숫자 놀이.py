def egcd(a, b):
    x, y, u, v = 0, 1, 1, 0
    while a != 0:
        q, r = b // a, b % a
        m, n = x - u * q, y - v * q
        b, a, x, y, u, v = a, r, u, v, m, n
    if b != 1:
        return False
    return x, y


t = int(input())
for case in range(1, t + 1):
    A, B = map(int, input().split())
    ans = egcd(A, B)
    if ans:
        print(f'#{case} {ans[0]} {ans[1]}')
    else:
        print(f'#{case} -1')