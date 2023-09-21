import sys
input = sys.stdin.readline

n = int(input())
meeting = [tuple(map(int,input().split())) for _ in range(n)]
meeting.sort(key = lambda x:(x[1], x[0]))

count = 0
end_time = 0
for m in meeting:
    if m[0] >= end_time:
        end_time = m[1]
        count+=1
        
print(count)