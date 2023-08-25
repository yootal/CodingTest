import sys
input = sys.stdin.readline
from collections import defaultdict
    
k,l = map(int,input().split())
student_dict = defaultdict(int)

for i in range(l):
    student_dict[input().rstrip()] = i

student_id = list(student_dict.keys())
student_id.sort(key = lambda x: student_dict[x])

if k > len(student_id):
    k = len(student_id)

for i in range(k):
    print(student_id[i])