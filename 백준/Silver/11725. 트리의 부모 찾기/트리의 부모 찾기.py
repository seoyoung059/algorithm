import sys
input = sys.stdin.readline
from collections import deque

def dfs(g,v,visited,parent):
    # visited[v]=True
    stack = deque([(0,1)])
    while len(stack)>0:
        p,c=stack.pop()
        if not visited[c]:
            visited[c]=True
            parent[c]=p
            for i in g[c]:
                if not visited[i]:
                    stack.append([c,i])
    for j in parent[2:]:
        print(j)
        
n=int(input())
g=[[] for i in range(n+1)]
for _ in range(n-1):
    a,b = map(int,input().split())
    g[a].append(b)
    g[b].append(a)
    g[a].sort()
    g[b].sort()
    
visited=[False]*(n+1)
parent = [None]*(n+1)

dfs(g,1,visited,parent)