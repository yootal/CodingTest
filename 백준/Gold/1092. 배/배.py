from sys import stdin
input = stdin.readline

n = int(input())
crane = list(map(int,input().split()))
m = int(input())
box = list(map(int,input().split()))

crane.sort(reverse=True)
box.sort(reverse=True)
ans = 0

if crane[0] < box[0]:
    ans = -1
else:
    while box:
        for cw in crane:
            if box and cw < box[-1]:
                continue
            for bw in box:
                if cw >= bw:
                    box.remove(bw)
                    break
        ans += 1
print(ans)