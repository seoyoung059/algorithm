import heapq
import sys
input = sys.stdin.readline

n=int(input())
meeting=[]
for _ in range(n):
    start,end = map(int,input().split())
    meeting.append((end, start))
meeting.sort()
    
end=0
cnt=0
for e,s in meeting:
    if s>=end:
        end=e
        cnt+=1
print(cnt)