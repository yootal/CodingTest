import sys
input=sys.stdin.readline

n,m = map(int,input().split())
book = list(map(int,input().split()))
book_p = []
book_m = []

for b in book:
    if b < 0:
        book_m.append(b)
    else:
        book_p.append(b)
book_p.sort()
book_m.sort(reverse=True)

ans = 0
if not book_m or book_p and book_p[-1] >= abs(book_m[-1]):
    ans += book_p[-1]
    for _ in range(m):
        if book_p:
            book_p.pop()
elif not book_p or book_m and book_p[-1] < abs(book_m[-1]):
    ans += abs(book_m[-1])
    for _ in range(m):
        if book_m:
            book_m.pop()
            
while book_p or book_m:
    if not book_m or book_p and book_p[-1] >= abs(book_m[-1]):
        ans += (book_p[-1]) * 2
        for _ in range(m):
            if book_p:
                book_p.pop()
    elif not book_p or book_m and book_p[-1] < abs(book_m[-1]):
        ans += abs(book_m[-1]) * 2
        for _ in range(m):
            if book_m:
                book_m.pop()
                
print(ans)