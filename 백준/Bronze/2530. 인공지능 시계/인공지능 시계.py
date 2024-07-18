h, m, s = map(int, input().split())
ss = s + 60 * m + 60 * 60 * h
ss += int(input())
hh = ss // (60 * 60)
ss %= (60 * 60)
mm = ss // 60
ss %= 60
print(f"{hh if hh < 24 else hh % 24} {mm} {ss}")