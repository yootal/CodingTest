def y(t):
    cost = (t // 30) * 10
    if t % 30 >= 0:
        cost += 10
    return cost

def m(t):
    cost = (t // 60) * 15
    if t % 60 >= 0:
        cost += 15
    return cost

n = int(input())
num = list(map(int,input().split()))
yc, mc = 0, 0
for num2 in num:
    yc += y(num2)
    mc += m(num2)
    
if mc < yc:
    print(f"M {mc}")
elif mc > yc:
    print(f"Y {yc}")
else:
    print(f"Y M {yc}")
