from sys import stdin, maxsize
input = stdin.readline

def dist(p1,p2):
    return abs(p1[0]-p2[0]) + abs(p1[1]-p2[1])

n = int(input())

check_point = []
for _ in range(n):
    x,y = map(int,input().split())
    check_point.append((x,y))
    
dist_list = []
for i in range(1,n):
    dist_list.append(dist(check_point[i-1],check_point[i]))

total = sum(dist_list)
min_dist = maxsize
for i in range(1,n-1):
    cur_dist = total - (dist_list[i-1] + dist_list[i])
    cur_dist += dist(check_point[i-1],check_point[i+1])
    min_dist = min(min_dist,cur_dist)
print(min_dist)    