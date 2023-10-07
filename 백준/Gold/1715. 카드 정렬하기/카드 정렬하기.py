# 카드 정렬하기
import heapq


def sol():
    n = int(input())
    hq = []
    for i in range(n):
        heapq.heappush(hq, int(input()))
    
    if n<2:
        return 0
    
    answer = 0
    while len(hq)>1:
        a = heapq.heappop(hq)
        b = heapq.heappop(hq)
        answer += a+b
        heapq.heappush(hq, a+b)
    
    return answer

print(sol())

