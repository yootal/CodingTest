import sys
input = sys.stdin.readline

n = int(input()) 

num = 1
time = 0
while n > 0:
    if num > n:    
        num = 1      
    n -= num        
    num += 1       
    time += 1
    
print(time)