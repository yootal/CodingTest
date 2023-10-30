from collections import deque

fibonacci = [0,1]
for x in range(2,46):
    fibonacci.append(fibonacci[x-1] + fibonacci[x-2])
    
t = int(input())
for _ in range(t):
    n = int(input())
    ans = deque()
    for i in range(45,0,-1):
        if fibonacci[i] <= n:
            ans.appendleft(fibonacci[i])
            n -= fibonacci[i]
            if n == 0:
                for a in ans:
                    print(a,end=" ")
                print()
                break