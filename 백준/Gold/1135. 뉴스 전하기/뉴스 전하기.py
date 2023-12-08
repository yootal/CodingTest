from sys import stdin
from collections import defaultdict
input = stdin.readline

def dp(cur):
    possible_time = []
    if not graph[cur]:
        possible_time.append(0)
    else:
        for nxt in graph[cur]:
            dp(nxt)
            possible_time.append(node_time[nxt])
    possible_time.sort(reverse=True)
    total_time = [possible_time[i] + i + 1 for i in range(len(possible_time))] # 걸리는 시간 목록
    node_time[cur] = max(total_time) # 최대 시간을 기록
    
n = int(input())
num = list(map(int,input().split()))
graph = defaultdict(list)
for x in range(1,n):
    graph[num[x]].append(x)
node_time = [0] * n
dp(0)
print(node_time[0] - 1)
        