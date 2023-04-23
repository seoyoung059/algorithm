import sys
input=sys.stdin.readline
from collections import deque

def bfs(g, v, visited):
    cnt=0
    visited[v]=True
    queue = deque([v])
    while len(queue)>0:
        c = queue.popleft()
        for i in g[c]:
            if not visited[i]:
                visited[i]=True
                queue.append(i)
                cnt+=1
    print(cnt)

n = int(input())
m = int(input())
g=[[] for i in range(n+1)]
for _ in range(m):
    a,b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)
    g[a].sort()
    g[b].sort()

virus=[False]*(n+1)
bfs(g,1,virus)