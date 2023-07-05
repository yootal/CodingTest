import sys
input=sys.stdin.readline

def nm(ans):
      if len(ans)==n2:
            return print(*ans)
      for i in range(1,n1+1):
            if i not in ans:
                  if len(ans) == 0:
                        ans.append(i)
                        nm(ans)
                        ans.pop()
                  elif ans[-1] < i:
                        ans.append(i)
                        nm(ans)
                        ans.pop()


n1,n2 = map(int,input().split(" "))

nm([])