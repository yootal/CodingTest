from sys import stdin
input = stdin.readline

def calc_slope(a1,b1,a2,b2):
    return (b2-b1) / (a2-a1)

n = int(input())
buildings = list(map(int,input().split()))

ans = 0
for i,y in enumerate(buildings):
    x = i + 1
    
    cur_right_slope = None
    right_cnt = 0
    for j in range(i+1,n+1):
        if j == n:
            break
        x2 = j + 1
        y2 = buildings[j]
        right_slope = calc_slope(x,y,x2,y2)
        if cur_right_slope is None or cur_right_slope < right_slope:
            cur_right_slope = right_slope
            right_cnt += 1
    
    cur_left_slope = None
    left_cnt = 0
    for k in range(i-1,-1,-1):
        if k == -1:
            break
        x2 = k + 1
        y2 = buildings[k]
        left_slope = calc_slope(x,y,x2,y2)
        if cur_left_slope is None or cur_left_slope > left_slope:
            cur_left_slope = left_slope
            left_cnt += 1
    
    if ans < left_cnt + right_cnt:
        ans = left_cnt + right_cnt

print(ans)