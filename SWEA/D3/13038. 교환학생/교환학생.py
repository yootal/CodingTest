from collections import deque
t = int(input())
for case in range(1,t+1):
    n = int(input())
    day = deque(list(map(int,input().split())))
    answer = 0
    cnt = day.count(1)
    ans = (n // cnt) * 7
    if n % cnt == 0:
        ans -= 7
        r = cnt
    else:
        r = n % cnt
    for _ in range(7):
        st_ans = ans
        st_r = r
        day.append(day.popleft())
        for i in range(7):
            if day[i] == 1:
                st_r -= 1
                st_ans += 1
                if st_r == 0:
                    break  
            else:
                st_ans += 1
        if answer == 0:
            answer = st_ans
        else:
            answer = min(answer,st_ans)
    print(f"#{case} {answer}")