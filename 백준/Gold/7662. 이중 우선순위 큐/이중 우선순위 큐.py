import sys, heapq
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    visited = [False] * n
    max_heap, min_heap = [], []
    for i in range(n):
        command, value = input().rstrip().split()
        value = int(value)
        if command == 'I':
            heapq.heappush(min_heap,(value, i))
            heapq.heappush(max_heap,(-value, i))
            visited[i] = True
        if command == 'D':
            if value == 1:
                while max_heap and not visited[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    visited[max_heap[0][1]] = False
                    heapq.heappop(max_heap)
            elif value == -1:
                while min_heap and not visited[min_heap[0][1]]:
                    heapq.heappop(min_heap)
                if min_heap:
                    visited[min_heap[0][1]] = False
                    heapq.heappop(min_heap)
                        
    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)
    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)
    if max_heap and min_heap:
        print(-max_heap[0][0], min_heap[0][0]) 
    else: 
        print("EMPTY")