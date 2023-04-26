import sys
input = sys.stdin.readline
from collections import deque

def bfs(graph, v, visited):
    visited[v]=True
    queue = deque([v])
    while len(queue)>0:
        curr = queue.popleft()
        for i in graph[curr]:
            if not visited[i]:
                visited[i]=True
                queue.append(i)

def sol(n,g,visited):
    cnt=0
    for i in range(1,n+1):
        if not visited[i]:
            bfs(g,i,visited)
            cnt+=1
    print(cnt)

n,m = map(int, input().split())
g=[[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

    


visited=[False]*(n+1)
sol(n,g,visited)