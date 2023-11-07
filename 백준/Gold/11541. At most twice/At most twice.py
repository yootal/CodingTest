from sys import stdin
input = stdin.readline

U = input().rstrip()
initial = int(''.join(U))
u = list(map(int,U))
l = len(u)

twice_check = True
for i in range(10):
    cnt = u.count(i)
    if cnt > 2:
        twice_check = False
        break
if twice_check:
    print(initial)
    exit()
    
def down(idx,ans,ans_list):
    i = 0
    while ans[idx] - i >= -1:
        ans2 = ans[:]
        ans2[idx] -= i
        if ans2[idx] == -1 :
            ans2[idx] = 9
            idx -= 1
            ans2[idx] -= 1
            while ans2[idx] == -1:
                ans2[idx] = 9
                idx -= 1
                ans2[idx] -= 1

        cnt = [2] * 10
        flag = False
        for j in range(idx+1):
            if j == 0 and ans2[j] == 0:
                continue
            cnt[ans2[j]] -= 1
            if cnt[ans2[j]] < 0:
                flag = True
                break
        i += 1
        if flag:
            continue
        
        for k in range(9,-1,-1):
            if len(ans2) == l:
                    break
            while cnt[k] > 0:
                cnt[k] -= 1
                ans2.append(k)
                if len(ans2) == l:
                    break
        result = int(''.join(map(str,ans2)))
        if result < initial:
            ans_list.add(result)
        
def solve():
    global ans_list
    for cur in range(l):
        ans = u[:cur+1]
        down(cur,ans,ans_list)       
        
ans_list = set()
solve()
ans_list2 = set()
for num in ans_list:
    s = str(num)
    flag2 = False
    for i in range(10):
        if s.count(str(i)) > 2:
            flag2 = True
            break
    if flag2:
        continue
    ans_list2.add(num)
    
print(max(ans_list2))