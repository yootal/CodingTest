num1=list(map(int,input().split()))
num2=list(map(int,input().split()))
ans = 0
for i in range(3):
    if num2[i] > num1[i]:
         ans += num2[i] - num1[i]
print(ans)