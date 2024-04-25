s1 = list(map(int, input().split()))
s2 = list(map(int, input().split()))
total1 = s1[0] * 6 + s1[1] * 3 + s1[2] * 2 + s1[3] * 1 + s1[4] * 2
total2 = s2[0] * 6 + s2[1] * 3 + s2[2] * 2 + s2[3] * 1 + s2[4] * 2
print(f"{total1} {total2}")