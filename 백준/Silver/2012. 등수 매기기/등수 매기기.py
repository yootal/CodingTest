from sys import stdin
input = stdin.readline

n = int(input())
prediction = [int(input()) for _ in range(n)]
prediction.sort()

ans = 0
for i in range(n):
    if (i+1) != prediction[i]:
        ans += abs(prediction[i]-(i+1))
        
print(ans)