import sys
input = sys.stdin.readline
import heapq

n=int(input())
card=[]
for _ in range(n):
    c= int(input())
    heapq.heappush(card,c)
    
ans=0
if len(card)==1:
    print(ans)
else:
    for i in range(n-1):
        a=heapq.heappop(card)
        b=heapq.heappop(card)
        ans += a+b
        heapq.heappush(card,a+b)
    print(ans)