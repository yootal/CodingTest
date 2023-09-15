n,w,h = map(int,input().split())
d = (w**2 + h**2) ** 0.5
for _ in range(n):
    l = int(input())
    print("DA" if l <= d else "NE")