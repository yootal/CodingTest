import sys
input = sys.stdin.readline
    
n = int(input())
student = list(map(int,input().split()))
student.sort()

def two_pointer(st,en,find):  
    global ans  
    max_idx = n
    while st < en:
        value = student[st] + student[en]
        if value < find:
            st += 1
        elif value == find:
            if student[st] == student[en]:
                ans += (en - st)
            else:
                if max_idx > en:
                    max_idx = en
                    while max_idx > st and student[max_idx - 1] == student[en]:
                        max_idx -= 1
                ans += en - max_idx + 1
            st += 1
        else:
            en -= 1
                
ans = 0
for i in range(n-2):
    st = i + 1
    en = n - 1       
    two_pointer(st,en,-student[i]) 
        
print(ans)
