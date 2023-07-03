import sys
input=sys.stdin.readline
l = []
n = int(input().strip())
count_dict={}
for _ in range(n):
      inp = int(input().strip())
      l.append(inp)
      if inp not in count_dict:
            count_dict[inp] = 0
      count_dict[inp] += 1
l.sort()


print(round(sum(l)/n)) # 평균
print(l[(n-1)//2]) # 중앙값
# 빈도
max_value = max(count_dict.values())
max_list = sorted([key for key, val in count_dict.items() if val == max_value])
if len(max_list) == 1:
      print(max_list[0])
else:
      print(max_list[1])
print(l[n-1]-l[0]) # 범위
            
