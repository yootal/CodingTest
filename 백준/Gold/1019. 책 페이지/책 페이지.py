from sys import stdin
from collections import defaultdict, Counter

n = int(input())
cnt = defaultdict(int)
flag = n

# 초기화
for i in range(10):
    cnt[str(i)] = 0

# 10미만일 때    
if n < 10:
    for i in range(1,n+1):
        cnt[str(i)] += 1
    print(*cnt.values())
    exit()
    
# 10의 몇 제곱 단위 까지 인지 (100단위면 idx = 2)
idx = 0
while n > 10 ** (idx+1) - 1:
    idx += 1
idx_st = idx 
    
finish = [] # 카운팅 완료
record = 0

while True:
    part_n = n // 10**(idx) * 10**(idx) # 맨 앞자리 수 기준부터 나눠서 계산
    record += part_n
    if part_n == 0:
        finish.append(str(n//10**idx))
        n %= 10**(idx)
        idx -= 1
        continue
    if idx > 0:
        # 1 ~ 10**(idx -1) 까지 0~9 까지 개수 먼저 구해둠
        cnt['0'] += 10**(idx-1)*(idx-1 if idx > 1 else 1) - int('1'*(idx-1 if idx > 1 else 1))
        for i in range(1,10):
            cnt[str(i)] += 10**(idx-1)*idx
            
        # 맨 처음 idx가 아닐때, 앞자리 수와 part_n 사이 공백 0 개수
        if idx != idx_st:
            for i in range(idx):
                cnt['0'] += 10**(i) * 9 * (idx-i)

        # 10**(idx) 씩 더하면서 part_n까지의 각 자리수 개수 구함
        st = 10**(idx) - 1
        while part_n >= st + 10**(idx):
            st += 10**(idx)
            cnt['0'] += 10**(idx-1)*idx
            cnt[str(st//(10**idx))] += 10**idx
            for i in range(1,10):
                cnt[str(i)] += 10**(idx-1)*idx

        # (x)999.. 까지 구해뒀으니 (x+1)000 개수까지 더해줌
        for cur in range(st+1,part_n+1):
            for k,v in Counter(str(cur)).items():
                cnt[k] += v

        # 이미 개수 센 앞 자리 수들 개수도 더해줌
        for i in range(len(finish)):
            cnt[finish[i]] += part_n
        
        # 완료한 자리 수 카운팅 완료 배열에 넣음
        finish.append(str(n//10**idx))

        # 더해온 값이 n이랑 같으면 끝        
        if record == flag:
            break
        
        # 다음에 셀 값 갱신
        n %= 10**(idx)
        idx -= 1

    else: # 1의 자리 수 계산
        for i in range(1,part_n+1):
            for x in finish:
                cnt[x] += 1
            cnt[str(i)] += 1
        break

print(*cnt.values())
