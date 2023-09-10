a = input()
b = input()
cnt = [0] * 26

for a2 in a:
    cnt[ord(a2) - ord('a')] += 1
for b2 in b:
    cnt[ord(b2) - ord('a')] -= 1
   
ans = 0 
for cnt2 in cnt:
    if cnt2 != 0:
       ans += abs(cnt2)
print(ans) 