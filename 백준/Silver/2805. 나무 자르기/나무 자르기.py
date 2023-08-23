import sys
input = sys.stdin.readline

def binary_search():
    st = 1
    en = max(tree)
    
    while st <= en:
        mid = (st + en) // 2
        cnt = 0
        for t in tree:
            if mid < t:
                cnt += (t - mid)
        if cnt >= m:
            st = mid + 1
        else:
            en = mid - 1
    return en

n,m = map(int,input().split())
tree = list(map(int,input().split()))
print(binary_search())