import sys
input = sys.stdin.readline

first = list(input().split())
num_list = list(map(lambda x: int(x[::-1]),first[1:]))

while len(num_list) < int(first[0]):
    input_num = list(map(lambda x: int(x[::-1]),input().split()))
    for i in input_num:
        num_list.append(i)

num_list.sort()
for n in num_list:
    print(n)