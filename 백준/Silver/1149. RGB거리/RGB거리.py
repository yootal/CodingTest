import sys 
input = sys.stdin.readline

n = int(input())

rgb_list = [[0 for _ in range(3)] for _ in range(1000)]
r_list = []
g_list = []
b_list = []

for _ in range(n):
    r,g,b = map(int,input().split())
    r_list.append(r)
    g_list.append(g)
    b_list.append(b)
    
    
rgb_list[0][0] = r_list[0]
rgb_list[0][1] = g_list[0]
rgb_list[0][2] = b_list[0]
    
for i in range(1,n):
    rgb_list[i][0] = min(rgb_list[i-1][1],rgb_list[i-1][2]) + r_list[i]
    rgb_list[i][1] = min(rgb_list[i-1][0],rgb_list[i-1][2]) + g_list[i]
    rgb_list[i][2] = min(rgb_list[i-1][0],rgb_list[i-1][1]) + b_list[i]

print(min(rgb_list[n-1][0],rgb_list[n-1][1],rgb_list[n-1][2]))
    

            
        