import sys
from collections import deque
input = sys.stdin.readline

def dfs(g,s,visited):
    global order
    visited[s]=1
    for i in g[s]:
        if visited[i]==0:
            dfs(g,i,visited)
    order.append(s)
    
def dfs_all(g,s,visited,n):
    for i in range(1,n+1):
        if visited[i]==0:
            dfs(g,i,visited)
            
n,m = map(int,input().split())
g=[]
for _ in range(n+1):
    g.append([])
for _ in range(m):
    a,b = map(int,input().split())
    g[a].append(b)
    
visited=[0]*(n+1)
order=deque()
dfs_all(g,1,visited,n)
while order:
    print(order.pop(),end=' ')