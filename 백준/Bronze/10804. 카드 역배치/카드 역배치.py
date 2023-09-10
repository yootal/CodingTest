num = list(range(1,21))
for _ in range(10):
    a,b = map(int,input().split())
    num[a-1:b] = reversed(num[a-1:b])
print(*num)