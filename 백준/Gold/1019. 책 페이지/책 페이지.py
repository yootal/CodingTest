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
    
idx = 0
while n > 10 ** (idx+1) - 1:
    idx += 1
idx_st = idx
    
finish = [] # 카운팅 완료
record = 0
while True:
    part_n = n // 10**(idx) * 10**(idx)
    record += part_n
    # print('part',part_n)
    # print('idx',idx)
    # temp = 0
    if part_n == 0:
        finish.append(str(n//10**idx))
        n %= 10**(idx)
        idx -= 1
        continue
    if idx > 0:
        cnt['0'] += 10**(idx-1)*(idx-1 if idx > 1 else 1) - int('1'*(idx-1 if idx > 1 else 1))
        if idx != idx_st:
            # temp = 0
            for i in range(idx):
                cnt['0'] += 10**(i) * 9 * (idx-i)
                # temp += 10**(i) * 9 * (idx-i)
            # print('temp',temp)
        for i in range(1,10):
            cnt[str(i)] += 10**(idx-1)*idx
            # temp += 10**(idx-1)*idx

        st = 10**(idx) - 1
        while part_n >= st + 10**(idx):
            st += 10**(idx)
            cnt['0'] += 10**(idx-1)*idx
            # temp += 10**(idx-1)*idx
            cnt[str(st//(10**idx))] += 10**idx
            # temp += 10**idx
            for i in range(1,10):
                cnt[str(i)] += 10**(idx-1)*idx
                # temp += 10**(idx-1)*idx

        for cur in range(st+1,part_n+1):
            for k,v in Counter(str(cur)).items():
                cnt[k] += v

        for i in range(len(finish)):
            # print(temp)
            cnt[finish[i]] += part_n
        # print(10**(idx-1)*(idx-1 if idx > 1 else 1) - int('1'*(idx-1 if idx > 1 else 1)))
        # cnt['0'] += 10**(idx-1)*(idx-1 if idx > 1 else 1) - int('1'*(idx-1 if idx > 1 else 1))
        
            
        finish.append(str(n//10**idx))
        
        # print('record',record)
        if record == flag:
            break
        
        n %= 10**(idx)
        idx -= 1
        # print('next',n)
        # print(*cnt.values())
        # print()
    else:
        # print(finish)
        for i in range(1,part_n+1):
            for x in finish:
                cnt[x] += 1
            cnt[str(i)] += 1
        # print(*cnt.values())
        break
# print('result',*cnt.values())
print(*cnt.values())