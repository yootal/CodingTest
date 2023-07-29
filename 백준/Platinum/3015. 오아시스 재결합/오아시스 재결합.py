import sys
input = sys.stdin.readline

n = int(input())
num_list = []
for _ in range(n):
    num_list.append(int(input()))
    
stack = []
s_count = 0 # 스택 수 카운트
ans = 0 # 답 카운트

for num in num_list:
    if s_count > 0:
        # 비교할 값이 스택 탑보다 클 때
        if num > stack[-1][0]:
            while stack and stack[-1][0] <= num:
                value, count = stack.pop()
                s_count -= count
                ans += count
            # 뺀 값과 새로 넣을 값이 같으면, 다르면
            if num == value:
                if s_count > 0:
                    ans += 1
                stack.append((num, count + 1))
                s_count += (count + 1)
            else: 
                if s_count > 0:
                    ans += 1
                stack.append((num, 1))
                s_count += 1
        # 비교할 값이 스택 탑보다 작을 때
        elif num < stack[-1][0]:
            ans += 1
            stack.append((num, 1))
            s_count += 1
        # 비교할 값이 스택 탑이랑 같을 때
        else:
            value, count = stack.pop()
            s_count -= count
            ans += count
            if s_count >0:
                ans += 1
            stack.append((num,count + 1))
            s_count += (count + 1)
    else:   
        stack.append((num,1))
        s_count += 1
    
print(ans)