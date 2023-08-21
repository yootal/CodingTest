import sys
input = sys.stdin.readline

n = int(input())
flower = []
for _ in range(n):
    f = list(map(int,input().split()))
    flower.append([f[0] * 100 + f[1], f[2] * 100 + f[3]])

flower.sort(key = lambda x : (x[0], x[1]))

cnt = 0 # 선택한 꽃 개수
end = 0 # 마지막 꽃의 지는날
target = 301 # 3월 1일

while flower:
    # 마지막 꽃 지는날이 12월 1일 보다 크거나 같을 때, 마지막 꽃의 지는날이 제일 팔리 피는 꽃보다 작으면 멈춤
    if target >= 1201 or target < flower[0][0]:
        break
    
    for _ in range(len(flower)):
        if target >= flower[0][0]:
            if end <= flower[0][1]:
                end = flower[0][1]
            
            flower.remove(flower[0])
        else:
            break
    target = end
    cnt += 1
    
if target < 1201:
    print(0)
else:
    print(cnt)