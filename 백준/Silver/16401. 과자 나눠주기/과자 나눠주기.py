import sys
input = sys.stdin.readline

def binary_search():
    st = 0
    en = max(cookie)
    
    while st < en:
        mid = (st + en + 1) // 2
        cnt = 0
        for c in cookie:
            cnt += (c // mid)
        if cnt >= m:
            st = mid
        else:
            en = mid - 1
    return st

m,n = map(int,input().split())
cookie = list(map(int,input().split()))
cookie.sort()
print(binary_search())
