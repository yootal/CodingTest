from sys import stdin, maxsize
from itertools import permutations
input = stdin.readline

t = int(input())
for case in range(1,t+1):
    num = input().strip()
    num_list = list(num)
    n = len(num)
    
    sorted_list = sorted(num_list,reverse=True)
    if sorted_list == num_list:
        if '0' in sorted_list:
            zero_idx = num_list.index('0')
            sorted_list2 = sorted(num_list[:zero_idx])
            ans = [sorted_list2[0]] + num_list[zero_idx:] + ['0'] + sorted_list2[1:]
        else:
            ans = sorted_list[-1:] + ['0'] + sorted(sorted_list[:-1]) 
        print(f"Case #{case}: {''.join(ans)}")
    else:
        ans_list = []
        i = 2
        while i <= n:
            cur = n-i
            temp = num_list[cur:]
            if sorted(temp,reverse=True) == temp:
                i += 1
                continue
            init = int(''.join(temp))
            nxt = maxsize
            for per in permutations(temp,i):
                per_int = int(''.join(per))
                if per_int > init:
                    nxt = min(nxt,per_int)
            ans = num_list[:cur] + list(str(nxt))
            print(f"Case #{case}: {''.join(ans)}")
            break
    