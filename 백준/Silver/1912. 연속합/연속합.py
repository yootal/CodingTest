import sys 
input = sys.stdin.readline

n = int(input())
numbers = list(map(int,input().split()))

for i in range(1,n):
    numbers[i] = max(numbers[i],numbers[i-1]+numbers[i])        
                
print(max(numbers))