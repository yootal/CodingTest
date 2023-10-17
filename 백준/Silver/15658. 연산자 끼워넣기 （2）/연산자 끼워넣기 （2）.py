from sys import stdin, maxsize
input = stdin.readline

n = int(input())
num = list(map(int,input().split()))
a,b,c,d = map(int,input().split())

def back_tracking(cur,cnt,total):
    global _max,_min,a,b,c,d
    if cnt == n-1:
        _max = max(_max,total)
        _min = min(_min,total)
        return
    for i in range(4):
        if i == 0 and a > 0:
            a -= 1
            back_tracking(cur + 1, cnt + 1,total+num[cur])
            a += 1
        elif i == 1 and b > 0:
            b -= 1
            back_tracking(cur + 1, cnt + 1,total-num[cur])
            b += 1
        elif i == 2 and c > 0:
            c -= 1
            back_tracking(cur + 1, cnt + 1,total*num[cur])
            c += 1
        elif i == 3 and d > 0:
            d -= 1
            back_tracking(cur + 1, cnt + 1,int(total/num[cur]))
            d += 1

_max = -maxsize
_min = maxsize
back_tracking(1,0,num[0])
print(_max)
print(_min)