import sys
input = sys.stdin.readline
from collections import deque


def dfs(graph, v, visited):
    visited[v]=True
    print(v, end=' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)
            
def bfs(graph, v, visited):
    visited[v]=True
    queue = deque([v])
    while len(queue)>0:
        curr = queue.popleft()
        print(curr, end=' ')
        for i in graph[curr]:
            if not visited[i]:
                visited[i]=True
                queue.append(i)
                
n,m,v = map(int, input().split())
g=[[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)
    g[a].sort()
    g[b].sort()

visited_dfs = [False]*(n+1)
visited_bfs = [False]*(n+1)

dfs(g,v,visited_dfs)
print()
bfs(g,v,visited_bfs)