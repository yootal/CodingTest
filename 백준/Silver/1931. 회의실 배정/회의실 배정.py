import sys
input = sys.stdin.readline

size = int(input())

meeting = []

for _ in range(size):
    meeting.append(list(map(int,input().split())))

meeting.sort(key = lambda x:(x[1], x[0]))

count = 0
end_time = 0
for m in meeting:
    if m[0] >= end_time:
        end_time = m[1]
        count+=1
        
print(count)