t  = int(input())
for case in range(1,t+1):
    n = int(input())
    all = []
    for _ in range(n):
        a,b = input().rstrip().split()
        for _ in range(int(b)):
            all.append(a)
    
    ans = []
    string = ""
    for i in range(len(all)):
        if len(string) < 10:
            string += all[i]
            if len(string) == 10:
                ans.append(string)
                string = ""
    ans.append(string)
    
    print(f"#{case}")
    for doc in ans:
        print(''.join(doc))