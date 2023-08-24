import sys
input = sys.stdin.readline
    
n = int(input())
num = list(map(int,input().split()))
check = [False] * 100001

check[num[0]] = True
ans = 0
en = 0
for st in range(n):
    # en에 st에서 en까지 같은 수가 등장하지 않는 가장 큰 값 저장
    while en < n-1 and not check[num[en+1]]:
        en += 1 
        check[num[en]] = True
    ans += (en - st + 1)
    check[num[st]] = False
    
print(ans)