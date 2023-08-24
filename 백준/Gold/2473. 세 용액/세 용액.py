import sys
input = sys.stdin.readline

n = int(input())
solutions = list(map(int,input().split()))
solutions.sort()

ans = sys.maxsize
ans_base = 0
ans_st = 0
ans_en = 0

for i in range(n-2):
    for j in range(i+1,n-1):
        base = solutions[i]
        current = solutions[j]
        st = j + 1
        en = n 
        
        while st < en:
            mid = (st + en) // 2
            check = base + current + solutions[mid]
            
            if abs(check) < ans:
                ans = abs(check)
                ans_base = i
                ans_left = j
                ans_right = mid
                if check == 0:
                    break
                
            if check < 0:
                st = mid + 1
            else:
                en = mid

print(solutions[ans_base], solutions[ans_left], solutions[ans_right])