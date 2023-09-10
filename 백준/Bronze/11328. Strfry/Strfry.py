n = int(input())
for _ in range(n):
    a,b = input().split()
    cnt = [0] * 26
    
    for a2 in a:
        cnt[ord(a2) - ord('a')] += 1
    for b2 in b:
        cnt[ord(b2) - ord('a')] -= 1
        
    flag = True
    for cnt2 in cnt:
        if cnt2 != 0:
            print("Impossible")
            flag = False
            break
    if flag:
        print("Possible")