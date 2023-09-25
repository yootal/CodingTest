import sys
input = sys.stdin.readline

n = int(input())
budget = list(map(int,input().split()))
budget.sort()
m = int(input())

def parametric_search():
    st = 1
    en = budget[-1]

    while st < en:
        mid = (st + en + 1) // 2
        
        total = 0
        for b in budget:
            if b < mid:
                total += b
            else:
                total += mid
                
        if total > m:
            en = mid - 1 
        else:
            st = mid
            
    return st

print(parametric_search())
