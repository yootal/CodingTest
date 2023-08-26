import sys, heapq
input = sys.stdin.readline

n = int(input())
max_question = []
min_question = []
solved = []

for _ in range(n):
    p,l = map(int,input().split())
    heapq.heappush(min_question,(l,p))
    heapq.heappush(max_question,(-l,-p))
    
m = int(input())
for _ in range(m):
    command = list(input().rstrip().split())
    if command[0] == 'add':
        command[1] = int(command[1])
        command[2] = int(command[2])
        heapq.heappush(min_question,(command[2],command[1]))
        heapq.heappush(max_question,(-command[2],-command[1]))
    elif command[0] == 'recommend':
        if command[1] == '-1':
            while min_question and min_question[0][1] in solved:
                solved.remove(heapq.heappop(min_question)[1])
            print(min_question[0][1])
        elif command[1] == '1':
            while max_question and -max_question[0][1] in solved:
                solved.remove(-heapq.heappop(max_question)[1])
            print(-max_question[0][1])
    elif command[0] == 'solved':
        command[1] = int(command[1])
        solved.append(command[1])
        