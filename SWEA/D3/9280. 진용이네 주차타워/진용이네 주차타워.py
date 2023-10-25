from collections import deque
t = int(input())
for case in range(1,t+1):
    n,m = map(int,input().split())
    price = [int(input()) for _ in range(n)]
    weight = [int(input()) for _ in range(m)]     
    parking = [0] * n  
    cnt = 0 
    order = deque()
    ans = 0
    for _ in range(2*m):
        car = int(input())
        if car > 0:
            if cnt < n:
                for i in range(n):
                    if not parking[i]:
                        cnt += 1
                        parking[i] = car
                        ans += weight[car-1] * price[i]
                        break
            else:
                order.append(car)
        else:
            car = abs(car)
            for i in range(n):
                if parking[i] == car:
                    if order:
                        nxt_car = order.popleft()
                        parking[i] = nxt_car
                        ans += weight[nxt_car-1] * price[i]
                    else:
                        cnt -= 1
                        parking[i] = 0
                    break
    print(f"#{case} {ans}")