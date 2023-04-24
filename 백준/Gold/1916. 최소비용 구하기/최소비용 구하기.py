import sys
import heapq
input=sys.stdin.readline

def di(g,s,e,distance):
    q=[]
    heapq.heappush(q,(0,s))
    distance[s]=0

    while len(q)>0:
        d,c = heapq.heappop(q)
        if distance[c] < d:
            continue
        for i,p in g[c]:
            if distance[i] > d+p:
                distance[i]=d+p
                heapq.heappush(q,(d+p,i))
    print(distance[e])
    
n=int(input())
m=int(input())
g=[[] for _ in range(n+1)]
for _ in range(m):
    a,b,p=map(int,input().split())
    g[a].append((b,p))
s,e = map(int,input().split())

distance=[10**8]*(n+1)
di(g,s,e,distance)