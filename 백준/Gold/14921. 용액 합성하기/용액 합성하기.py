import sys
input = sys.stdin.readline

n = int(input())
solutions = list(map(int,input().split()))

ans = sys.maxsize
ans_st = 0
ans_en = 0

for i in range(n-1):
    current = solutions[i]
    st = i + 1
    en = n - 1
    
    while st <= en:
        mid = (st + en) // 2
        check = current + solutions[mid]
        if abs(check) < ans:
            ans = abs(check)
            ans_left = i
            ans_right = mid
            if check == 0:
                break
            
        if check < 0:
            st = mid + 1
        else:
            en = mid - 1

print(solutions[ans_left] + solutions[ans_right])