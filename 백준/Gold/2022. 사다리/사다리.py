from sys import stdin
input = stdin.readline

x,y,c = map(float,input().split())
st = 0
en = min(x,y)
ans = 0

def f(x,y,v):
    h1 = (x**2-v**2)**0.5
    h2 = (y**2-v**2)**0.5
    return h1*h2 / (h1+h2)

while en - st > 0.000001:
    mid = (st + en) / 2
    if f(x,y,mid) >= c:
        ans = mid
        st = mid
    else:
        en = mid
print(ans)