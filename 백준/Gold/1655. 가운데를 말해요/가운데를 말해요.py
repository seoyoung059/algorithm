import sys
input = sys.stdin.readline
import heapq


heap1=[]
heap2=[]
n=int(input())
ans=[]

for _ in range(n):
    new = int(input())
    if len(heap1)==len(heap2):
        heapq.heappush(heap1,(-new,new))
    else:
        heapq.heappush(heap2,(new))
    while len(heap1)>0 and len(heap2)>0:
        a1 = heap1[0][1]
        a2 = heap2[0]
        if a1 > a2:
            heapq.heappop(heap1)
            heapq.heappush(heap1,(-a2,a2))
            heapq.heappop(heap2)
            heapq.heappush(heap2,a1)
        else:
            break
    print(heap1[0][1])
