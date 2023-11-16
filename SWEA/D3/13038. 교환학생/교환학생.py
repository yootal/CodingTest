from collections import deque

t = int(input())
for case in range(1, t + 1):
    n = int(input())
    day = deque(list(map(int, input().split())))
    day_cnt = day.count(1)
    week_cnt = n // day_cnt * 7
    if n % day_cnt == 0:
        ans = week_cnt
        week_cnt -= 7
        r = day_cnt
    else:
        ans = week_cnt + 7
        r = n % day_cnt
    for _ in range(7):
        st_ans = week_cnt
        st_r = r
        day.append(day.popleft())
        for d in day:
            st_ans += 1
            if d:
                st_r -= 1
                if st_r == 0:
                    ans = min(ans, st_ans)
                    break
    print(f'#{case} {ans}')