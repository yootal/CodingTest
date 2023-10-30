from sys import stdin
input = stdin.readline        

n = int(input())
ball = input().rstrip()

cnt = []
cnt.append(ball.rstrip('R').count('R'))
cnt.append(ball.rstrip('B').count('B'))
cnt.append(ball.lstrip('R').count('R'))
cnt.append(ball.lstrip('B').count('B'))

print(min(cnt))