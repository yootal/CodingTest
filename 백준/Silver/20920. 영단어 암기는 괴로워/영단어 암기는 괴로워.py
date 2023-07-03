import sys
input=sys.stdin.readline
count_dict = {}
n1, n2 = map(int,input().split(" "))
for _ in range(n1):
      inp = input().strip()
      if len(inp)<n2:
            continue
      else:
            if inp in count_dict.keys():
                  count_dict[inp] += 1
            else:
                  count_dict[inp] = 1
sorted_list = sorted(count_dict.items(), key = lambda x: (-x[1], -len(x[0]),x[0]))
for r in sorted_list:
      print(r[0])