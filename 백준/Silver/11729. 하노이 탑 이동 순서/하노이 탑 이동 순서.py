import sys
input=sys.stdin.readline

count = 0
result_list = []
def hanoi_move(n, start, end) :
      
      global count, result_list
      
      if n == 1 :
            result_list.append(str(start)+" "+str(end))
            count += 1
            return
       
      hanoi_move(n-1, start, 6-start-end)           # 1단계
      result_list.append(str(start)+" "+str(end))   # 2단계
      count += 1
      hanoi_move(n-1, 6-start-end, end)             # 3단계
    
n = int(input())

hanoi_move(n, 1, 3)

print(count)
for i in result_list:
      print(i)