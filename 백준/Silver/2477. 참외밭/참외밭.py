import sys
input = sys.stdin.readline

n = int(input())
farm = [list(map(int,input().split())) for _ in range(6)]

w = 0
w_idx = 0
h = 0
h_idx = 0

for i in range(len(farm)):
    if farm[i][0] == 1 or farm[i][0] == 2:
        if w < farm[i][1]:
            w = farm[i][1]
            w_idx = i
    elif farm[i][0] == 3 or farm[i][0] == 4:
        if h < farm[i][1]:
            h = farm[i][1]
            h_idx = i

w2 = abs(farm[(w_idx - 1) % 6][1] - farm[(w_idx + 1) % 6][1])            
h2 = abs(farm[(h_idx - 1) % 6][1] - farm[(h_idx + 1) % 6][1])

print(((w*h) - (w2*h2)) * n)            
            