import sys 
input = sys.stdin.readline

size,q = map(int,input().split())

num_list=[]

for _ in range(size):
    num_list.append(list(map(int,input().split())))
    
dp = [0]*(size**2)
    
for j in range(size):
    for i in range(size):
        if i == 0:
            dp[size*j] = num_list[j][0]
        else:
            dp[size*j+i] = dp[size*j+i-1]+num_list[j][i]

for _ in range(q):
    x1,y1,x2,y2 = map(int,input().split())
    total = 0
    x1 -=1
    y1 -=1
    y2 -=1
    for i in range(x1,x2):
        if y1 == 0:
            total += dp[size*i+y2]
        else:
            total += (dp[size*i+y2]-dp[size*i+y1-1])
    print(total)
            

            
        