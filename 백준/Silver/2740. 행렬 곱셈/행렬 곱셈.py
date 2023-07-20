import sys
input = sys.stdin.readline

a_list = []
b_list = []

a1,a2 = map(int,input().split())

for _ in range(a1):
    a_list.append(list(map(int,input().split())))
    
b1,b2 = map(int,input().split())

for _ in range(b1):
    b_list.append(list(map(int,input().split())))
    
ans = [[0] * b2 for _ in range(a1)]

for i in range(a1):
    for j in range(b2):
            for k in range(a2):
                ans[i][j] += (a_list[i][k] * b_list[k][j])
    
for a in ans:
    print(" ".join(str(a1) for a1 in a))