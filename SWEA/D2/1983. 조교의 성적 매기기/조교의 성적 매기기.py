t  = int(input())
score = ['A+','A0','A-','B+','B0','B-','C+','C0','C-','D0']
for case in range(1,t+1):
    n,k = map(int,input().split())
    student = []
    for i in range(1,n+1):
        a,b,c = map(int,input().split())
        student.append((a*35 + b*45 + c*20,i))
    student.sort(reverse=True)
    gap = n // 10
    for i in range(1,n+1):
        if student[i][1] == k:
            print(f"#{case} {score[i//gap]}")
            break
