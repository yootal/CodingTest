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
        # if ans[cur] == 0:
        #     ans[cur] = 9
        #     cur -= 1
        #     ans[cur] -= 1
        #     while ans[cur] == -1:
        #         ans[cur] = 9
        #         cur -= 1
        #         ans[cur] -= 1
        # else:
        #     ans[cur] -= 1
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
        # else:
        #     ans[cur] -= 1
        
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
                cnt[k]-=1
                ans2.append(k)
                if len(ans2) == l:
                    break
        # print(ans2)
        result = int(''.join(map(str,ans2)))
        ans_list.add(result)
        
    
def solve():
    global ans_list
    pre = 0
    for cur in range(l):
        # idx = cur
        ans = u[:cur+1]
        # ans2 = u[:cur+1]
        
        # cnt = [2] * 10
        # flag = False
        # for j in range(idx+1):
        #     cnt[ans[j]] -= 1
        #     if cnt[ans[j]] < 0:
        #         flag = True
        #         break
        # if flag:
        #     continue
        
        # for k in range(9,-1,-1):
        #     if len(ans2) == l:
        #         break
        #     while cnt[k] > 0:
        #         cnt[k]-=1
        #         ans2.append(k)
        #         if len(ans2) == l:
        #             break
        # result = int(''.join(map(str,ans2)))
        # ans_list.append(result)
                
        down(cur,ans,ans_list)       
        # if ans[cur] == 0:
        #     ans[cur] = 9
        #     cur -= 1
        #     ans[cur] -= 1
        #     while ans[cur] == -1:
        #         ans[cur] = 9
        #         cur -= 1
        #         ans[cur] -= 1
        # else:
        #     ans[cur] -= 1
        # cnt = [2] * 10
        
        # flag = False
        # for j in range(idx+1):
        #     if j == 0 and ans[j] == 0:
        #         continue
        #     cnt[ans[j]] -= 1
        #     if cnt[ans[j]] < 0:
        #         flag = True
        #         break
        # if flag:
        #     continue
        
        # for k in range(9,-1,-1):
        #     if len(ans) == l:
        #             break
        #     while cnt[k] > 0:
        #         cnt[k]-=1
        #         ans.append(k)
        #         if len(ans) == l:
        #             break
        # print(ans)
        # result = int(''.join(map(str,ans)))
        # ans_list.append(result)
    
ans_list = set()
solve()
ans_list2 = []
# print(ans_list)
for a2 in ans_list:
    if a2 > initial:
        continue
    s = str(a2)
    flag2 = False
    for i in range(10):
        if s.count(str(i)) > 2:
            flag2 = True
            break
    if flag2:
        continue
    ans_list2.append(a2)
# print('ans1:',max(ans_list))
print(max(ans_list2))

# def is_valid(L):
#     digits = [0] * 10  # 0부터 9까지의 숫자를 추적하는 리스트
#     while L > 0:
#         digit = L % 10  # 현재 자릿수
#         L //= 10  # 다음 자릿수로 이동
#         digits[digit] += 1  # 해당 숫자의 등장 횟수 증가
#         if digits[digit] > 2:
#             return False  # 숫자가 두 번 이상 나타난 경우 False 반환
#     return True

# # U = int(input())  # U 입력 받기

# # U부터 역순으로 L을 찾음
# for L in range(initial, 0, -1):
#     if is_valid(L):
#         print('ans2:',L)  # L 출력
#         break