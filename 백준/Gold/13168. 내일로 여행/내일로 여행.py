import sys
input = sys.stdin.readline

type1 = {'ITX-Saemaeul', 'ITX-Cheongchun', 'Mugunghwa'}
type2 = {'S-Train', 'V-Train'}
type3 = {'Subway', 'Bus', 'Taxi', 'Airplane', 'KTX'}

n,r = map(int,input().split())
inf = sys.maxsize

city = list(input().rstrip().split())
city_arr = [[[inf] * (n) for _ in range(n)] for _ in range(2)]

m = int(input())
travel_city = list(input().rstrip().split())

k = int(input())
for _ in range(k):
    type,s,e,cost = input().rstrip().split()
    cost = int(cost) * 2
    s_idx = city.index(s)
    e_idx = city.index(e)
    cost = min(city_arr[0][s_idx][e_idx],cost)
    city_arr[0][s_idx][e_idx] = cost
    city_arr[0][e_idx][s_idx] = cost
    
    if type in type1:
        cost = 0
    elif type in type2:
        cost //= 2
        
    cost = min(city_arr[1][s_idx][e_idx],cost)
    city_arr[1][s_idx][e_idx] = cost
    city_arr[1][e_idx][s_idx] = cost
    
for i in range(n):
    city_arr[0][i][i] = 0
    city_arr[1][i][i] = 0
    
for k in range(n):
    for i in range(n):
        for j in range(n):
            for l in range(2):
                city_arr[l][i][j] = min(city_arr[l][i][j], city_arr[l][i][k] + city_arr[l][k][j])
            
price = 0
dc_price = 0
for i in range(1,m):
    price += city_arr[0][city.index(travel_city[i-1])][city.index(travel_city[i])]
    dc_price += city_arr[1][city.index(travel_city[i-1])][city.index(travel_city[i])]

if price <= dc_price + r*2:
    print("No")
else:
    print("Yes")