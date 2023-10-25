t = int(input())
for case in range(1,t+1):
    n,k = map(int,input().split())
    student = list(range(1,n+1))
    submit = list(map(int,input().split()))
    for x in submit:
        student.remove(x)
    print(f"#{case}",end=" ")
    print(*student)