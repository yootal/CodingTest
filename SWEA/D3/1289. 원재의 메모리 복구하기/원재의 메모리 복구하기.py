t = int(input())
for case in range(1, t + 1):
    ans = 0
    n = list(map(int, input()))
    st = n[0]
    if st == 1:
        ans += 1
    for i in range(1, len(n)):
        if n[i] != st:
            st = n[i]
            ans += 1
    print(f"#{case} {ans}")
