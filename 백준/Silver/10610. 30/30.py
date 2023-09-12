n = list(input())
n.sort(reverse=True)

if "0" not in n:
    print(-1)
else:
    to_int = map(int,n)
    if sum(to_int) % 3 != 0:
        print(-1)
    else:
        print("".join(n))