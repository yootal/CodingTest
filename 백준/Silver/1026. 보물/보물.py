import sys
input=sys.stdin.readline

n = int(input())
arr_a = list(map(int,input().split()))
arr_b = list(map(int,input().split()))
arr_a2 = sorted(arr_a)
arr_b2 = sorted(arr_b,reverse=True)
ans = 0
for i in range(n):
    ans += (arr_a2[i] * arr_b2[i])
print(ans)