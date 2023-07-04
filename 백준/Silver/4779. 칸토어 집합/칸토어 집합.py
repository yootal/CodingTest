import sys
input=sys.stdin.readline

def change(n):
      if n == 1:
            return "-"
      else:
            r = n // 3
            return change(r) + " "*r + change(r)            
            
while True:
      try:
            inp = input().rstrip()
            # if inp =="":
            #       break
            # else:
            p = pow(3,int(inp))
            print(change(p))
      except : 
            break 
